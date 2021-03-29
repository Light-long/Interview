package com.tx.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 什么是CAS？
 * CompareAndSwap 比较并交换
 *
 * 如果期望值与物理内存的真实值相同，就修改值
 * 如果不相同，就重新获取主内存的值
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2000);
        System.out.println("before value："+atomicInteger.get()+"\t"+
                // compareAndSet(期望值，修改值)
                atomicInteger.compareAndSet(2000, 2021)+" \t current value:"+atomicInteger.get());

    }
}
