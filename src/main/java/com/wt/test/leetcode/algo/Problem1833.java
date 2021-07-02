package com.wt.test.leetcode.algo;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量
 * https://leetcode-cn.com/problems/maximum-ice-cream-bars/
 *
 * @author 一贫
 * @date 2021/7/2
 */
public class Problem1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int index = 0;
        while (coins > 0 && index < costs.length) {
            if (coins < costs[index])
                break;
            coins -= costs[index];
            count++;
            index++;
        }
        return count;
    }
}
