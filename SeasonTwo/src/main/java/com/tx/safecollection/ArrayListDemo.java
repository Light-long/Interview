package com.tx.safecollection;

import java.util.*;

/**
 * ArrayList默认初始化一个Object[] elementData = {}
 * 第一次add元素的时候扩容
 *
 * ArrayList多线程下 java.util.ConcurrentModificationException并发修改异常
 * 怎么处理？
 * - Vector
 * - 工具类：Collections.synchronizedList(new ArrayList<>())
 * - CopyOnWriteArrayList
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
