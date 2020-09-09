package com.wt.test.leetcode.algo;

/**
 * 26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author 一贫
 * @date 2020/9/9
 */
public class Problem26 {

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index])
                continue;
            nums[++index] = nums[i];
        }
        return index + 1;
    }
}
