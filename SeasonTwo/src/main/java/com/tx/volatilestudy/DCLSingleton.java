package com.tx.volatilestudy;

/**
 * DoubleCheckLock 双端检索机制
 */
public class DCLSingleton {
    // 使用volatile禁止指令重排
    private volatile static DCLSingleton instance = null;

    private DCLSingleton() {
        System.out.println("我是DCLSingleton构造方法");
    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 100; i > 0; i--) {
            new Thread(DCLSingleton::getInstance,String.valueOf(i)).start();
        }
    }
}
