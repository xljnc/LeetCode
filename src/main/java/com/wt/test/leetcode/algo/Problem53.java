package com.wt.test.leetcode.algo;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author 一贫
 * @date 2021/4/13
 */
public class Problem53 {

    public static void main(String[] args) {
        Problem53 problem53 = new Problem53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = problem53.maxSubArray(nums);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            max = Math.max(pre, max);
        }
        return max;
    }

}
