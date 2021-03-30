package com.tx.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable接口:
 * 适配器模式
 * new Thread(Runnable run)-->FutureTask间接实现了Runnable
 * new FutureTask(Callable callable)
 */

/**
 * Callable接口的优势：
 * - 有返回值
 * - 可以抛异常
 * - 泛型
 */

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("callable...");
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(thread);
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        System.out.println(futureTask.get());

    }
}
