package com.tx.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 人齐发车
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // public CyclicBarrier(int parties, Runnable barrierAction)
        CyclicBarrier barrier = new CyclicBarrier(7, () -> {
            System.out.println("*******召唤神龙*******");
        });

        for (int i=1;i<=7;i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 收集到了第："+temp+"颗龙珠");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
