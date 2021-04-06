package com.tx.heap;

import java.util.*;

public class LC692 {
    public List<String> topKFrequent(String[] words, int k) {
        // 存放返回结果
        List<String> list = new ArrayList<>();
        // 统计每个单词出现的次数
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word,map.get(word)+1);
            } else {
                map.put(word,1);
            }
        }
        // 创建一个最小堆
        // 出现次数相等，按照字母排序
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (s1, s2)->map.get(s1).equals(map.get(s2)) ?
                        s2.compareTo(s1) : map.get(s1)-map.get(s2));
        // 将所有的元素放入,当当大于k是，弹出当前最小
        for (String key : map.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) minHeap.poll();
        }
        // 取出堆中元素
        while (!minHeap.isEmpty()) {
            list.add(minHeap.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
