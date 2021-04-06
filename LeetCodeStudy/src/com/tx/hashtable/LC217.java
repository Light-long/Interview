package com.tx.hashtable;

import java.util.HashMap;
import java.util.HashSet;

//给定一个整数数组，判断是否存在重复元素。
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
public class LC217 {
    public boolean containsDuplicate(int[] nums) {
        // key--元素
        // value--出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 计算每个元素出现的次数
        for (int num : nums) {
            int i = 1;
            if (!map.containsKey(num)) {
                map.put(num,i);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size()==nums.length ? false:true;
    }
}
