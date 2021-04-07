package com.tx.divideandconquer;

import java.util.HashMap;

public class LC169 {

    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num,1);
            } else {
                map.put(num,map.get(num)+1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) > nums.length/2)
                return num;
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        return getMaxCountElement(nums,0,nums.length-1);
    }

    public int getMaxCountElement(int[] nums,int left,int right) {
        // 数组中只有一个元素停止
        if (left == right) return nums[left];
        // 数组中多个元素
        int mid = left+(right-left)/2;
        // 出现次数最多的元素
        int leftMax = getMaxCountElement(nums,left,mid);
        int rightMax = getMaxCountElement(nums,mid+1,right);
        // 两边的出现次数最多的元素相同
        if (leftMax == rightMax) return leftMax;
        // 不同，则遍历小数组，找出出现次数最多的元素
        int leftCount = 0;
        int rightCount = 0;
        for (int i=left;i<=right;i++) {
            if (nums[i] == leftMax) leftCount++;
            if (nums[i] == rightMax) rightCount++;
        }
        return leftCount>=rightCount ? leftMax:rightMax;
    }
}
