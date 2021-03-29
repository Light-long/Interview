package com.tx.safecollection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全的ArrayList：CopyOnWriteArrayList
 * - 写时复制(读写分离的思想)
 * CopyOnWrite容器即写时复制的容器。
 * - 往一个容器添加元素的时候，不直接往当前容器Object[]添加，
 * - 而是先将当前容器Object[]进行Copy，
 * - 复制出一个新的容器Object[] newElements，这个容器的容量是 之前的容量+1，
 * - 然后向新的容器Object[] newElements里添加元素。
 * - 添加元素后，再将原容器的引用指向新的容器 setArray(newElements)。
 * 这样做的好处是可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。
 * 所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    }
}
