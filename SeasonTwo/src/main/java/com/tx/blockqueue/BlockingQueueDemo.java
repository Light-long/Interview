package com.tx.blockqueue;

/**
 * 阻塞队列：火锅店，银行（不得不阻塞）
 * 阻塞队列是空的时候，从队列中获取元素的操作会被阻塞
 * 阻塞队列是满的时候，从队列中添加元素的操作会被阻塞
 *
 * - 阻塞队列的好处
 *      - 不需要关心什么时候阻塞线程，什么时候唤醒线程
 * - 不得不阻塞，如何管理
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQueue:接口，Collection的子接口
 *  - ArrayBlockingQueue：数组组成的 有界 阻塞队列
 *  - LinkedBlockingQueue：链表组成的 有界（Integer.MaxValue） 阻塞队列
 *  - SynchronousQueue：不存储元素的阻塞队列，也即 单个元素的阻塞队列
 */

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
        /**
         * 抛出异常
         * 插入，移除，取队列头的方法
         * add()/remove()/element()
         * 当阻塞队列满时，再往队列里add插入元素会抛IllegalStateException:Queue full
         * 当阻塞队列空时，再往队列里remove移除元素会抛NoSuchElementException
         */
        //blockingQueue.add("win");
        // java.lang.IllegalStateException: Queue full
        // blockingQueue.add("win");
        // blockingQueue.remove();
        // java.util.NoSuchElementException
        // blockingQueue.remove();
        // win
        //System.out.println(blockingQueue.element());

        /**
         * 不抛出异常
         * 插入，删除，取队头
         * offer()/poll()/peek()
         * 插入方法，成功ture失败false
         * 移除方法，成功返回出队列的元素，队列里没有就返回null
         */

        /**
         * 阻塞方法
         * put()/take()
         * 当阻塞队列满时，生产者线程继续往队列里put元素，队列会一直阻塞生产者线程直到put数据or响应中断退出
         * 当阻塞队列空时，消费者线程试图从队列里take元素，队列会一直阻塞消费者线程直到队列可用
         */

        /**
         * 超时退出
         * offer(e,time,unit)/poll(time,unit)
         * 当阻塞队列满时，队列会阻塞生产者线程一定时间，超过限时后生产者线程会退出
         */
        blockingQueue.offer("mac",1, TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
    }
}
