package com.tx.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 * - 多个线程按照申请锁的顺序来获取锁，类似于队列，（先来后到）
 * 非公平锁
 * - 多个线程获取锁的顺序并不是按照申请锁的顺序，有可能后申请的先获取锁（先强先得）
 * - 高并发下，可能造成优先级反转或饥饿现象
 * - 吞吐量大
 * - synchronized也是非公平锁
 */
public class FairLock {
    public static void main(String[] args) {
        // 默认非公平锁
        Lock lock = new ReentrantLock(false);
        // 构造参数true，公平锁
        Lock lock2 = new ReentrantLock(false);

    }
}
