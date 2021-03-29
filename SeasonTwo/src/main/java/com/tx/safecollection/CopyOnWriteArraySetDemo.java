package com.tx.safecollection;

/**
 * 解决HashSet的线程不安全问题：
 * - HashSet的底层是HastMap，add添加的是key，value是一个共用的object常量
 * 底层是CopyOnWriteArrayList
 */
public class CopyOnWriteArraySetDemo {
}
