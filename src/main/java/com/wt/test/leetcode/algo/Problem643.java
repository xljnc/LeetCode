package com.wt.test.leetcode.algo;

/**
 * 643. 子数组最大平均数 I
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 *
 * @author qiyu
 * @date 2021/2/4
 */
public class Problem643 {

    public static void main(String[] args) {
        Problem643 problem643 = new Problem643();
        int[] nums = {0, 4, 0, 3, 2};
        int k = 1;
        System.out.println(problem643.findMaxAverage(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int last = sum;
        for (int i = 1; i <= nums.length - k; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            if (last < sum)
                last = sum;
        }
        return ((double) last) / k;
    }
}
