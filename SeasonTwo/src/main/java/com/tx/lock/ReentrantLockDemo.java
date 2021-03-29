package com.tx.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁（递归锁）：ReentrantLock   synchronized
 * 线程在外层方法获取锁后，在进入内层方法时自动获取锁（同一把锁）
 * - 防止死锁
 * - 只要加锁解锁数量匹配，就可以执行，不匹配会死锁
 */

// 使用synchronized
class Phone{
    public synchronized void sendMS() {
        System.out.println(Thread.currentThread().getName()+"\t sendMS");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName()+"\t sendEmail");
    }
}

// 使用ReentrantLock
class Data implements Runnable{
    private static final Lock lock = new ReentrantLock();
    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t getData");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t setData");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        get();
    }
}
public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(phone::sendMS,"A").start();
        new Thread(phone::sendMS,"B").start();

        TimeUnit.SECONDS.sleep(3);

        Data data = new Data();
        new Thread(data).start();
        new Thread(data).start();
    }
}
