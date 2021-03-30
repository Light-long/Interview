package com.tx.threadpool;

import java.util.concurrent.*;

/**
 * 线程池的优势：
 * - 降低资源消耗。线程复用
 * - 提高响应速度。当任务到达时，任务可以不需要等待线程创建就能立即执行。
 * - 控制线程并发数
 */

/**
 * Executors.newFixedThreadPool(int):创建一个线程数固定的线程池
 * Executors.newSingleThreadPool(1):创建一个线程数为1的线程池
 * Executors.newCachedThreadPool():创建一个可以伸缩的线程池
 *
 * 底层都是ThreadPoolExecutor
 * ThreadPoolExecutor(int corePoolSize,         -- 常驻核心线程数
 *                    int maximumPoolSize,      -- 线程池能够容纳最大线程数
 *                    long keepAliveTime,       -- 多余空闲线程（非核心线程）的存活时间，
 *                                                 当前线程池中线程数量超过corePoolSize时，
 *                                                 当空闲时间达到keepAliveTime时，多余线程会被销毁，
 *                                                 直到只剩下corePoolSize个线程为止
 *                    TimeUnit unit,            -- keepAliveTime的单位
 *                    BlockingQueue<Runnable> workQueue, -- 任务队列，被提交但未被执行的任务
 *                    ThreadFactory threadFactory,       -- 线程工厂，一般默认
 *                    RejectedExecutionHandler handler)  -- 拒绝策略: 当任务队列满了，
 *                                                          且工作线程大于等于最大线程数时，如何处理新来的任务
 */

/**
 * 线程池工作流程：
 * - 创建线程池后，等待提交任务
 * - 当调用execute()方法添加一个任务时，线程会判断
 * -- 当前运行的线程数小于corePoolSize，则直接拿一个线程执行这个任务
 * -- 如果当前运行的线程数等于或大于corePoolSize，则将此任务放入工作队列中
 * -- 如果工作队列已满，但是正在运行的线程数小于maxPoolSize，则创建非核心线程立即执行此任务
 * -- 如果工作队列已满，且运行的线程数等于maxPoolSize，则启用 拒绝策略
 * - 当一个线程执行完任务后，他会从队列取出一个任务来执行
 * - 当一个线程 空闲时间等于keepAliveTime时，线程池会判断
 * -- 如果当前的线程数大于corePoolSize，那么销毁此线程
 * -- 直到线程数等于corePoolSize
 */

/**
 * 拒绝策略：
 * - AbortPolicy:默认，丢弃且报异常RejectedExecutionException
 * - DisCardPolicy: 直接丢弃任务，不报异常
 * - CallerRunsPolicy: 将任务回退到调用者
 * - DisCardOldestPolicy: 丢弃任务队列中等待最久的任务，把当前任务添加到任务队列
 */

/**
 * 线程池不使用Executors去创建，而是通过ThreadPoolExecutor创建
 * - FixedThreadPool和SingleThreadPool允许请求队列的长度为Integer.MaxSize,可能堆积大量的请求，导致OOM
 * - CachedThreadPool和ScheduledThreadPool，允许创建线程数为Integer.MaxSize,可能创建大量的线程，导致OOM
 */

/**
 * 如何配置线程池？
 * - Runtime.getRuntime().availableProcessors()获取逻辑处理器个数（核心数*2）
 * - CPU密集型：CPU核数+1
 * - IO密集型：CPU核数*2
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,1L,
                TimeUnit.SECONDS ,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 8; i > 0; i--) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
