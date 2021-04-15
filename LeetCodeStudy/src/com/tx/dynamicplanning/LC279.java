package com.tx.dynamicplanning;

import java.util.Arrays;

public class LC279 {
    public int numSquares(int n) {
        // 找到所有小于n的square number
        int maxSquareIndex = (int) Math.sqrt(n)+1;
        // 存放所有的square number
        int[] squareNumbers = new int[maxSquareIndex];
        for (int i=1;i<squareNumbers.length;i++) {
            squareNumbers[i] = i*i;
        }

        // dynamic planning
        // 每个数组中存，组成这个数需要的最小square number
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < squareNumbers.length; j++) {
                if (i < squareNumbers[j])
                    break;
                dp[i] = Math.min(dp[i], dp[i - squareNumbers[j]] + 1);
            }
        }
        return dp[n];
    }
}
