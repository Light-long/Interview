package com.tx.juc.latch;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

// 其他线程都执行完成，main线程再执行
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 6; i > 0; i--) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 被灭了");
                countDownLatch.countDown();
            },Objects.requireNonNull(Country.getNameByIndex(i))).start();
        }

        // 主线程最后执行
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t 秦统一六国");
    }
}
