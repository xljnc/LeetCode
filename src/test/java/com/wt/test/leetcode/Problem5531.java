package com.wt.test.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/contest/weekly-contest-209/problems/special-array-with-x-elements-greater-than-or-equal-x/
 *
 * @author 一贫
 * @date 2020/10/4
 */
public class Problem5531 {
    public static void main(String[] args) {
        Problem5531 problem5531 = new Problem5531();
        int[] nums = {3, 5};
        int result = problem5531.specialArray(nums);
        System.out.println(result);
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            if (i == length) {
                if (nums[0] >= length)
                    return length;
                else
                    return -1;
            }
            if (nums[length - 1 - i] < i && nums[length - i] >= i)
                return i;
        }
        return -1;
    }
}
