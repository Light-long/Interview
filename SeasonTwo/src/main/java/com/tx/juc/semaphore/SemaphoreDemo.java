package com.tx.juc.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 * 争车位：一进一出
 * - 多个共享资源的互斥使用
 * - 并发线程数的控制
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 模拟3个停车位
        Semaphore semaphore = new Semaphore(3);
        // 模拟6个车
        for (int i = 6; i > 0; i--) {
            final int temp = i;
            new Thread(()->{
                try {
                    // 获取信号量
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到了停车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t 停了3s后离开了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放信号量
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
