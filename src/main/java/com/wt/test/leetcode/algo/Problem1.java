package com.wt.test.leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author 一贫
 * @date 2020/9/3
 */
public class Problem1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (numMap.containsKey(left)) {
                result[0] = numMap.get(left);
                result[1] = i;
                return result;
            }
            numMap.put(nums[i], i);
        }
        return result;
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                result[0] = numMap.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
            numMap.put(nums[i], i);
        }
        return result;
    }
}