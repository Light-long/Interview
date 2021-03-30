package com.tx.prodconsumer;

/**
 * synchronized和Lock的区别？Lock的好处？
 * - synchronized是个关键字属于JVM层面
 *      - monitorenter，monitorexit(底层是通过monitor对象来完成，其实wait、notify等方法也是依赖monitor对象，
 *      只有在同步方法或同步代码块中才能使用wait、notify)
 * - Lock是java.util.concurrent.Locks.Lock，是api层面，是个接口
 *
 * - 使用方法
 * - synchronized不需要手动释放锁，当synchronized代码执行完，系统会让线程自动释放对锁的占用
 * - ReentrantLock需要手动释放锁，否则会产生死锁
 *
 * - synchronized不可中断，除非抛异常或者正常运行完成
 * - ReentrantLock可以中断
 *
 * - synchronized是非公平锁
 * - ReentrantLock默认非公平，但也可以传入true，为公平锁
 *
 * - synchronized不可以精准唤醒
 * - ReentrantLock通过Condition可以实现精准唤醒
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个线程之间按顺序调用，实现A->B->C三个线程启动，要求如下
 * AA打印五次，BB打印10次，CC打印15次
 * 循环10轮
 */
class ShareData3 {
    // A:1 B:2 C:3
    private int flag = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            // 判断
            while (flag != 1) {
                conditionA.await();
            }
            // 操作
            for (int i = 5; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+"\t printA"+i);
            }
            // 唤醒
            flag = 2;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            // 判断
            while (flag != 2) {
                conditionB.await();
            }
            // 操作
            for (int i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+"\t printB"+i);
            }
            // 唤醒
            flag = 3;
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            // 判断
            while (flag != 3) {
                conditionC.await();
            }
            // 操作
            for (int i = 15; i > 0; i--) {
                System.out.println(Thread.currentThread().getName()+"\t printC"+i);
            }
            // 唤醒
            flag = 1;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SynLockDiff {
    public static void main(String[] args) {
        // 线程操作资源类
        ShareData3 data3 = new ShareData3();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                data3.printA();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                data3.printB();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 10; i > 0; i--) {
                data3.printC();
            }
        },"CC").start();

    }
}
