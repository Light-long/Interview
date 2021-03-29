package com.tx.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：ReentrantReadWriteLock
 * - 读锁（共享锁）:保证写的时候不能读
 * - 写锁（独占锁）：synchronized，ReentrantLock
 *
 * 读-读 可以共存
 * 读-写 不能共存
 * 写-写 不能共存
 *
 * 写操作：原子+独占
 */
class MyCache {
    private volatile Map<String,Object> map = new HashMap<>();
    // 读写锁
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key,Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 数据放入缓存
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 正在读取"+key);
            // 从缓存中获取数据
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成:"+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) throws InterruptedException {
        // 资源类
        MyCache cache = new MyCache();
        // 5个线程写
        for (int i = 5; i > 0; i--) {
            final int temp = i;
            new Thread(()->{
                cache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        TimeUnit.SECONDS.sleep(1);
        // 5个线程读
        for (int i = 5; i > 0; i--) {
            final int temp = i;
            new Thread(()->{
                cache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}
