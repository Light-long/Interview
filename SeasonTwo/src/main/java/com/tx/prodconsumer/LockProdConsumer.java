package com.tx.prodconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock+Condition
 * await
 * signal
 */

class ShareData2 {
    private int number = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    // 加1
    public void increment() {
        lock.lock();
        try {
            // 判断
            while (number != 0) {
                condition.await();
            }
            // 操作
            System.out.println(Thread.currentThread().getName()+"\t 加一"+(++number));
            // 唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    // 减1
    public void decrement() {
        lock.lock();
        try {
            // 判断
            while (number == 0) {
                condition.await();
            }
            // 操作
            System.out.println(Thread.currentThread().getName()+"\t 减一"+(--number));
            // 唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class LockProdConsumer {
    public static void main(String[] args) {
        ShareData2 data2 = new ShareData2();
        new Thread(()->{
            for (int i = 5; i > 0; i--) {
                data2.increment();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 5; i > 0; i--) {
                data2.decrement();
            }
        },"B").start();
//        new Thread(()->{
//            for (int i = 5; i > 0; i--) {
//                data2.increment();
//            }
//        },"C").start();
//        new Thread(()->{
//            for (int i = 5; i > 0; i--) {
//                data2.decrement();
//            }
//        },"D").start();
    }
}
