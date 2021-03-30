package com.tx.prodconsumer;

/**
 * 传统的生产者消费者模式
 * 初始变量为0，两个线程交替操作，一个加一，一个减一，5轮
 * 使用synchronized实现
 *
 * 线程操作资源类
 * 判断 操作 唤醒
 * 防止虚假唤醒，判断用while
 */

/**
 * synchronized
 * wait
 * notify
 */
class ShareData1 {
    private int number = 0;

    // 增加1的方法
    // 使用synchronized，锁当前对象this
    public synchronized void increment() {
        while (number != 0) {
            // 阻塞
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"\t 加一"+(++number));
        // 唤醒其他线程
        this.notifyAll();
    }

    // 减1的方法
    public synchronized void decrement() {
        while (number == 0) {
            // 阻塞
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"\t 减一"+(--number));
        // 唤醒其他线程
        this.notifyAll();
    }
}
public class SynProdConsumer {
    public static void main(String[] args) {
        // 线程操作资源类
        ShareData1 data1 = new ShareData1();
        new Thread(() -> {
            for (int i = 5; i > 0; i--) {
                data1.increment();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 5; i > 0; i--) {
                data1.decrement();
            }
        },"B").start();
//        new Thread(() -> {
//            for (int i = 5; i > 0; i--) {
//                data1.increment();
//            }
//        },"C").start();
//        new Thread(() -> {
//            for (int i = 5; i > 0; i--) {
//                data1.decrement();
//            }
//        },"D").start();
    }
}
