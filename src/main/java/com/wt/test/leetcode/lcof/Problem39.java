package com.wt.test.leetcode.lcof;

import java.util.Arrays;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 *
 * @author 一贫
 * @date 2021/5/4
 */
public class Problem39 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
