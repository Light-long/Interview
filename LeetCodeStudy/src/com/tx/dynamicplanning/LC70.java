package com.tx.dynamicplanning;

public class LC70 {

    public int climbStairs(int n) {
        if (n < 2) {
            return n==1 ? 1:0;
        }
        // 0~n
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3;i<=n;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
