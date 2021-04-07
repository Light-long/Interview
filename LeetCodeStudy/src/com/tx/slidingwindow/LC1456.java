package com.tx.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1456 {
    public int maxVowels(String s, int k) {
        if (s == null || s.length() == 0 || s.length()<k) return 0;
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        // 计数
        int count = 0;
        // 最大数
        int max = 0;
        // 滑动窗口
        // 先把k个元素加入
        for (int i = 0;i<k;i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
            max = Math.max(count,max);
        }
        // 滑动
        for (int i=k;i<s.length();i++) {
            // 出去一个进来一个
            if (set.contains(s.charAt(i))) count++;
            if (set.contains(s.charAt(i-k))) count--;
            max = Math.max(count,max);
        }
        return max;
    }
}
