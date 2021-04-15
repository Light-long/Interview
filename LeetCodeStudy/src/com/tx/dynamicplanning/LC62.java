package com.tx.dynamicplanning;

public class LC62 {

    public int uniquePaths(int m, int n) {
        // 状态转移方程  F(i,j) = F(i-1,j)+F(i,j-1)
        // 初始状态 F(0,0) = 1
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                // 判断左边的格子是否存在
                if (j-1 >=0 && j-1<n) {
                    // dp[i][j]默认是0,加上左边的路径数
                    dp[i][j] = dp[i][j] + dp[i][j-1];
                }
                // 判断上边的格子是否存在
                if (i-1 >=0 && i-1<m) {
                    dp[i][j] = dp[i][j] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
