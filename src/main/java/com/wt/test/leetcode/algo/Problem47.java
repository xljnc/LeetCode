package com.wt.test.leetcode.algo;

import java.util.*;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author 一贫
 * @date 2020/10/3
 */
public class Problem47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>(16);
        List<Integer> input = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            input.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            permute(0, result, input);
        }
        return new ArrayList<>(result);
    }

    public void permute(int curr, Set<List<Integer>> result, List<Integer> input) {
        int size = input.size();
        if (curr == size) {
            result.add(new ArrayList<>(input));
        }
        for (int i = curr; i < size; i++) {
            Collections.swap(input, curr, i);
            permute(curr + 1, result, input);
            Collections.swap(input, curr, i);
        }
    }
}

