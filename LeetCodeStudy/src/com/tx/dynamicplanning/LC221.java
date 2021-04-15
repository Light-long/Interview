package com.tx.dynamicplanning;

public class LC221 {

    // 如果该位置的值是 00，则 \textit{dp}(i, j) = 0dp(i,j)=0，因为当前位置不可能在由 11 组成的正方形中；
    //
    //如果该位置的值是 11，则 \textit{dp}(i, j)dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。
    // 具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下：
    //dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
    //dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxSide = 0;

        int row = matrix.length;
        int col = matrix[0].length;
        // dp数组,默认每个位置都为0
        int[][] dp = new int[row][col];
        // 遍历matrix
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (matrix[i][j] == '1') {
                    // 在边上
                    if (i==0 || j==0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }
}
