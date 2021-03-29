package com.tx.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS缺点：
 * - 自旋锁循环耗CPU性能
 * - 只能保证一个共享变量的原子操作
 * - 引出ABA问题
 *      - 原子引用更新
 */
public class CASShortComing {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        new Thread(()->{
            // A--B--A
            atomicInteger.compareAndSet(10,20);
            atomicInteger.compareAndSet(20,10);
        },"B").start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicInteger.get());
        },"A").start();
    }
}
