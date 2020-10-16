package com.wt.test.leetcode.lcci;

/**
 * 面试题 17.04. 消失的数字
 * https://leetcode-cn.com/problems/missing-number-lcci/
 *
 * @author 一贫
 * @date 2020/10/16
 */
public class Problem1704 {

    public int missingNumber(int[] nums) {
        long sum = 0;
        long target = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (int) (target - sum);
    }
}
