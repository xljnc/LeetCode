package com.wt.test.leetcode.algo;

import java.util.Arrays;

/**
 * 1046. 最后一块石头的重量
 * https://leetcode-cn.com/problems/last-stone-weight/
 *
 * @author 一贫
 * @date 2020/12/30
 */
public class Problem1046 {

    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if (len == 1)
            return stones[0];
        if (len == 2)
            return Math.abs(stones[0] - stones[1]);
        Arrays.sort(stones);
        for (int i = 0; i < len - 1; i++) {
            stones[len - 1] = stones[len - 1] - stones[len - 2];
            stones[len - 2] = 0;
            Arrays.sort(stones);
        }
        return stones[len - 1];
    }
}
