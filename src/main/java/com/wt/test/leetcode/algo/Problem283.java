package com.wt.test.leetcode.algo;

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author 一贫
 * @date 2020/11/19
 */
public class Problem283 {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[j++] = nums[i];
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
