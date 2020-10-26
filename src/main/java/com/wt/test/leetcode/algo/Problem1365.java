package com.wt.test.leetcode.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1365. 有多少小于当前数字的数字
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * @author 一贫
 * @date 2020/10/26
 */
public class Problem1365 {
    public static void main(String[] args) {
        Problem1365 problem1365 = new Problem1365();
        int[] nums = {8, 1, 2, 2, 3};
        int[] result = problem1365.smallerNumbersThanCurrent(nums);
        System.out.println(result);
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(sorted[0], 0);
        for (int i = 1; i < sorted.length; i++) {
            if (counter.containsKey(sorted[i]))
                continue;
            counter.put(sorted[i], i);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = counter.get(nums[i]);
        }
        return result;
    }


    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            for (; j < sorted.length; j++) {
                if (nums[i] <= sorted[j])
                    break;
            }
            result[i] = j;
        }
        return result;
    }


}
