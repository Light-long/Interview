package com.tx.greedy;

public class LC55 {

    // 对于当前遍历到的位置 x，如果它在 最远可以到达的位置 的范围内，那么我们就可以从起点通过若干次跳跃到达该位置，因此我们可以用 x + \textit{nums}[x]x+nums[x] 更新 最远可以到达的位置
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int rightMost = 0;
        for (int i=0;i<len;i++) {
            // 这个位置可以达到
            if (i <= rightMost) {
                rightMost = Math.max(rightMost,i+nums[i]);
                // 达到最后一个索引
                if (rightMost >= len-1) {
                    return true;
                }
            }
        }
        return false;
    }
}
