package com.yitu.offerII.动态规划;


/**
 * https://leetcode.cn/problems/GzCJIP/
 */
public class 爬楼梯的最少成本 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        helper(cost, len - 1, dp);
        return Math.min(dp[len - 2], dp[len - 1]);
    }

    private void helper(int[] cost, int i, int[] dp) {
        if (i < 2) {
            dp[0] = cost[0];
            dp[1] = cost[1];
        } else if (dp[i] == 0) {
            helper(cost, i - 2, dp);
            helper(cost, i - 1, dp);
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
    }
}
