package com.wt.test.leetcode.lcof;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 *
 * @author qiyu
 * @date 2021/5/1
 */
public class Problem57 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0, right = nums.length - 1;
        if (nums[left] >= target)
            return result;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result[0] = nums[left];
                result[1] = nums[right];
                return result;
            } else if (sum < target)
                left++;
            else
                right--;
        }
        return result;
    }
}
