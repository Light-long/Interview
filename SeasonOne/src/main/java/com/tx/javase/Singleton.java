package com.tx.javase;

/**
 * 构造器私有化
 * 含有一个静态变量来保存这个这个唯一的实例
 * 对外提供获取该实例对象的方式:getInstance()
 */

/**
 * 双重检测
 * - 线程安全
 * - 延迟加载
 */
public class Singleton {
    private volatile static Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
