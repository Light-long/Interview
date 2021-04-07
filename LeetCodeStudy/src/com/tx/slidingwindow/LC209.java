package com.tx.slidingwindow;

public class LC209 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 滑动窗口取不到的值
        int res = nums.length+1;
        // 和
        int total = 0;
        // 滑动窗口的头
        int i = 0;
        // 滑动窗口的尾
        int j = 0;
        // 尾部j(右边)遍历
        while (j < nums.length) {
            total += nums[j];
            j = j+1;
            // 循环试图左边出队，找最小值
            while (total >= target) {
                // 最小长度
                res = Math.min(res,j-i);
                total -= nums[i];
                i++;
            }
        }
        return res==nums.length+1 ? 0:res;
    }
}
