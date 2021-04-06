package com.tx.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapDemo {
    public static void main(String[] args) {
        // 创建heap(默认是最小堆)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
}
