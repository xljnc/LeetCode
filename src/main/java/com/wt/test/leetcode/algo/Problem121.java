package com.wt.test.leetcode.algo;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author 一贫
 * @date 2021/7/8
 */
public class Problem121 {
    public int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > profit)
                profit = prices[i] - min;
            if (prices[i] < min)
                min = prices[i];
        }
        return profit;
    }
}
