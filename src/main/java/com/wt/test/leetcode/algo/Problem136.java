package com.wt.test.leetcode.algo;

/**
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author 一贫
 * @date 2021/4/20
 */
public class Problem136 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int x : nums) {
            result ^= x;
        }
        return result;
    }
}
