package com.tx.binarysearch;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = nums.length-1;
        // l=r时，没办法确定插入的位置
        while (i<j) {
            int mid = i + (j-i)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return nums[i]>=target ? i:i+1;
    }
}
