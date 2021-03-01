package com.wt.test.leetcode.algo;

/**
 * 1470. 重新排列数组
 * https://leetcode-cn.com/problems/shuffle-the-array/
 *
 * @author 一贫
 * @date 2021/3/1
 */
public class Problem1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result[i] = nums[index];
            result[i + 1] = nums[n + index++];
        }
        return result;
    }
}
