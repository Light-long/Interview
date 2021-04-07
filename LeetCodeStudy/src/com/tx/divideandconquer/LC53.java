package com.tx.divideandconquer;

public class LC53 {

    public int maxSubArray(int[] nums) {
        return getMaxSubArray(nums,0,nums.length-1);
    }

    public int getMaxSubArray(int[] nums,int left,int right) {
        if (left == right) return nums[left];
        int mid = left+(right-left)/2;
        int leftMax = getMaxSubArray(nums,left,mid);
        int rightMax = getMaxSubArray(nums,mid+1,right);
        // 两边联合的最大值
        int corssMax = getCorssMax(nums,left,right);
        return Math.max(Math.max(leftMax,rightMax),corssMax);
    }

    public int getCorssMax(int[] nums,int left,int right) {
        int mid = left+(right-left)/2;
        // 取左边的最大值
        // 左边和
        int leftSum = nums[mid];
        // 左边最大值
        int leftMax = leftSum;
        for (int i = mid-1;i>=left;i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftSum,leftMax);
        }
        // 取右边的最大值
        // 右边和
        int rightSum = nums[mid+1];
        // 右边最大值
        int rightMax = rightSum;
        for (int i = mid+2;i<=right;i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum,rightMax);
        }
        return leftMax+rightMax;
    }

    // dynamic planning
    public int maxSubArray2(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            // 当前最大（加一个元素以后）
            pre = Math.max(pre+num,num);
            // 最大
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }
}
