package com.wt.test.leetcode.algo;

/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author 一贫
 * @date 2020/10/2
 */
public class Problem300 {

    public static void main(String[] args) {
        Problem300 problem300 = new Problem300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = problem300.lengthOfLIS(nums);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        //这里写下思路，dp[i]其实代表的是以nums[i]为结尾的最长上升子串的长度
        for (int i = 1; i < nums.length; i++) {
            //roundMax代表dp[0]到dp[i-1]为止
            //nums[i]大于nums[j]的dp的最大值，
            //也就是以nums[i]为结尾，前面的最长升序子串元素必须小于nums[i]
            int roundMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    roundMax = Math.max(roundMax, dp[j]);
            }
            dp[i] = roundMax + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
