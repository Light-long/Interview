package com.tx.volatilestudy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile不保证原子性
 *
 * 什么是原子性？
 * 不可分割，完整性，也即是某个线程正在做某个具体业务时，中间不可以被加塞或者分割
 * 需要整体完整性，要么同时成功，要么同时失败
 *
 * 如何解决原子性？
 * - 加synchronized
 * - 原子类AtomicInteger
 */
public class VolatileNoAtomic {
    public static void main(String[] args) throws InterruptedException {
        MyData2 myData2 = new MyData2();
        // 20个线程，每个线程执行1000次addPlusPlus()，理论上number值为20000
        for (int i = 20; i > 0; i--) {
            new Thread(()->{
                for (int i1 = 1000; i1 > 0; i1--) {
                    myData2.addPlusPlus();
                    myData2.addByAtomic();
                }
            },String.valueOf(i)).start();
        }

        // 让上面的20个线程执行完之后，main线程取number的结果
        // 默认有两个线程：main，gc
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
//        TimeUnit.SECONDS.sleep(1);

        //main线程获取number的值<20000
        // 可能会造成 写覆盖，丢失值
        System.out.println(Thread.currentThread().getName()+" 取得number:"+myData2.number);
        System.out.println(Thread.currentThread().getName()+" 取得atomicInteger:"+myData2.atomicInteger);
    }
}

class MyData2 {
    volatile int number = 0;

    public void addPlusPlus() {
        number++;
    }

    // 原子类
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addByAtomic() {
        // 原子加1
        atomicInteger.getAndIncrement();
    }
}
