package com.tx.volatilestudy;

/**
 * volatile是JVM提供的 轻量级的同步机制，基本遵守了JMM的规范
 * - 保证可见性
 * - 不保证原子性
 * - 禁止指令重排（有序）
 */

import java.util.concurrent.TimeUnit;

/**
 * JMM： Java内存模型（抽象概念），描述一组规范，定义了程序中个变量的访问方式
 *  - 可见性
 *  - 原子性
 *  - 有序性
 * （volatile只保证两个）
 * 1. 线程解锁前，必须把 共享变量的值刷回主内存
 * 2. 线程加锁前，必须读取主内存的最新值到自己的工作内存
 * 3. 加锁解锁是同一把锁
 */
public class VolatileStudy {
    public static void main(String[] args) {
        // 线程操作资源类
        // 资源类
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 3s后A线程将number+1
            myData.addNumber();
            System.out.println(Thread.currentThread().getName()+"修改了number值，改为"+myData.number);
        },"A").start();

        // main线程操作
        while (myData.number == 1) {

        }
        // 结束任务
        System.out.println(Thread.currentThread().getName()+"获取到了number值："+myData.number);
        System.out.println(Thread.currentThread().getName()+"结束任务");
    }
}

class MyData {
    // volatile保证可见性，及时通知其他线程，主内存的值已经被修改
    volatile int number = 1;

    public void addNumber() {
        number = 10;
    }
}
