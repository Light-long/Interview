package com.tx.dynamicplanning;

import java.util.Arrays;

public class LC322 {

    public int coinChange(int[] coins, int amount) {
        // 不可能达到的纸币数量
        int max = amount+1;
        // dp[i]:组成金额i需要的最少数量
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        // 组成金额0需要0张
        dp[0] = 0;
        // 遍历所有金额
        for (int i=1;i<=amount;i++) {
            // 遍历每个金额
            for (int j=0;j<coins.length;j++) {
                // 如果这个金额小于当前amount，那么这个组成这个金额的最小张数就等于，
                // dp[i-coins[j]]+1,即加上一张当前金额组成amount
                if (coins[j]<=i) {
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        // 如果没有被修改，即为没办法组成
        return dp[amount]>amount ? -1:dp[amount];
    }
}
