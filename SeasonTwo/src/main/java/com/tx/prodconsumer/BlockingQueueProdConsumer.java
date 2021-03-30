package com.tx.prodconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用阻塞队列实现生产者、消费者模式
 * volatile,CAS,BlockingQueue,AtomicInteger
 */
class ShareData4 {
    // 标志位，默认开启，进行生产+消费
    private volatile boolean flag = true;
    // 默认0(数据)
    private AtomicInteger atomicInteger = new AtomicInteger();
    // 阻塞队列
    private BlockingQueue<String> blockingQueue = null;
    // 构造函数传入阻塞队列
    public ShareData4(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() {
        String data = null;
        boolean returnVal = false;
        while (flag) {
            try {
                data = atomicInteger.incrementAndGet()+"";
                returnVal = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (returnVal) {
                    System.out.println(Thread.currentThread().getName()+"\t 插入数据"+data+"成功");
                } else {
                    System.out.println(Thread.currentThread().getName()+"\t 插入数据"+data+"失败");
                }
                // 每次插入休息1s
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // flag = false
        System.out.println(Thread.currentThread().getName()+"\t flag = false, 停止生产模式");
    }
    public void myConsumer() {
        String returndata = null;
        while (flag) {
            try {
                returndata = blockingQueue.poll( 2, TimeUnit.SECONDS);
                if (returndata == null || "".equals(returndata)) {
                    this.flag = false;
                    // flag = false
                    System.out.println(Thread.currentThread().getName()+"\t flag = false, 停止消费模式");
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"\t 消费数据"+returndata+"成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop() {
        this.flag = false;
    }
}
public class BlockingQueueProdConsumer {
    public static void main(String[] args) throws InterruptedException {
        ShareData4 data4 = new ShareData4(new ArrayBlockingQueue<>(10));
        new Thread(data4::myProd,"Prod").start();
        new Thread(data4::myConsumer,"Consumer").start();

        // 5s后暂停生产消费
        TimeUnit.SECONDS.sleep(5);
        System.out.println("5s时间到，");
        data4.stop();
    }
}
