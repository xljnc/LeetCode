package com.wt.test.leetcode.algo;

/**
 * 674. 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 *
 * @author 一贫
 * @date 2021/1/24
 */
public class Problem674 {

    public static void main(String[] args) {
        Problem674 problem674 = new Problem674();
        int[] nums = {};
        int result = problem674.findLengthOfLCIS(nums);
        System.out.println(result);
    }

    public int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            } else {
                int curr = i - left;
                count = Math.max(count, curr);
                left = i;
            }
        }
        int last = nums.length - left;
        count = Math.max(count, last);
        return count;
    }
}
