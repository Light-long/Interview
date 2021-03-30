package com.tx.lock;

import java.util.concurrent.TimeUnit;

/**
 * DeadLock:
 * - 两个及以上线程，互相持有对方将需要的资源而不能主动释放，造成阻塞
 * 死锁定位分析：
 * - jps --查看java程序进程号
 * - jstack 进程号  --查看堆栈信息
 */

class ShareData implements Runnable{
    private String lockA;
    private String lockB;

    public ShareData(String lockA,String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockA+"\t 尝试获取"+lockB);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockB+"\t 尝试获取"+lockA);
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new ShareData(lockA,lockB),"ThreadA").start();
        new Thread(new ShareData(lockB,lockA),"ThreadB").start();
    }
}
