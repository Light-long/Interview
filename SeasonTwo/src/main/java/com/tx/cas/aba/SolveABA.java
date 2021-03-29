package com.tx.cas.aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 解决ABA问题
 * - 增加一个版本号（时间戳）
 * - AtomicStampedReference时间戳原子引用
 */
public class SolveABA {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("============ABA问题的产生============");
        new Thread(()->{
            // 完成一次ABA操作
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"A").start();
        new Thread(()->{
            // 等待线程A完成ABA操作
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 拿着修改后的100操作
            System.out.println(atomicReference.compareAndSet(100, 2021)+"\t 修改后的值为"+atomicReference.get());
        },"B").start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("=============ABA问题的解决============");
        new Thread(()->{
            // 获取时间戳
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号为"+stamp);
            // sleep一秒确保线程D获取到相同的时间戳
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"\t 第二次版本号为"+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t 第三次版本号为"+atomicStampedReference.getStamp());
        },"C").start();
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t 第一次版本号为"+atomicStampedReference.getStamp());
            // sleep三秒确保线程C完成一次ABA操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前最新版本"+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t是否修改成功："+atomicStampedReference.compareAndSet(100, 2021, stamp, stamp + 1));
            System.out.println(Thread.currentThread().getName()+"\t 当前最新值为："+atomicStampedReference.getReference());
        },"D").start();
    }
}
