package com.tx.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 尝试获取锁的线程不会立即阻塞，而是采用 循环的方式 去尝试获取锁（循环代替阻塞）
 * 没有获取到，先去干自己的事，然后再回来尝试获取锁
 * - 好处：减少线程上下文切换的消耗
 * - 缺点：消耗CPU资源
 */

// 手写自旋锁
public class SpinLock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        // 当前调用这个方法的线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in");
        // 自旋获取锁(如果当前没有线程，就放置此线程，否则一直自旋)
        while (!atomicReference.compareAndSet(null, thread)) {}
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        // 将原子引用置为空，让其他线程获取
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName()+"\t come out");
    }

    public static void main(String[] args) throws InterruptedException {
        // 线程操作资源类
        // 资源类
        SpinLock lock = new SpinLock();
        new Thread(()->{
            // 线程A获取锁
            lock.myLock();
            // 线程A操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 线程A释放锁
            lock.myUnLock();
        },"A").start();
        // 让线程A先获取到锁
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            // 线程B获取锁
            lock.myLock();
            // 线程B操作
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 线程B释放锁
            lock.myUnLock();
        },"B").start();
    }
}
