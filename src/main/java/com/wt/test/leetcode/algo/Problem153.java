package com.wt.test.leetcode.algo;

import java.util.Arrays;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author 一贫
 * @date 2021/4/8
 */
public class Problem153 {

    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}
