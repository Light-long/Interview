package com.tx.cas.aba;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子引用：将某个类包装成原子类
 * AtomicReference<Class>
 */

/**
 * 原子引用+版本号（时间戳）解决ABA问题
 */
class User{
    String name;
    int age;
}

public class AtomicReferenceStudy {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();
    }
}
