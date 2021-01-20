package com.wt.test.leetcode.algo;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 *
 * @author 一贫
 * @date 2021/1/20
 */
public class Problem628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int candidate1 = nums[0] * nums[1] * nums[nums.length - 1];
        int candidate2 = nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];
        return Math.max(candidate1, candidate2);
    }
}
