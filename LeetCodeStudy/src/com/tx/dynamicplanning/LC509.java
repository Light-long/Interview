package com.tx.dynamicplanning;

public class LC509 {

    public int fib(int n) {
        if (n<2) return n==1 ? 1:0;
        // dynamic planning
        int[] dp = new int[n+1];
        // 初始状态
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2;i<n+1;i++) {
            // 状态转移方程
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
