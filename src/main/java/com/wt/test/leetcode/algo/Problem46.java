package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author 一贫
 * @date 2020/9/29
 */
public class Problem46 {
    public static void main(String[] args) {
        Problem46 problem46 = new Problem46();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = problem46.permute(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        List<Integer> input = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            input.add(nums[i]);
        }
        backtrace(0, input, result);
        return result;
    }

    public void backtrace(int curr, List<Integer> input, List<List<Integer>> result) {
        int size = input.size();
        if (curr == size) {
            result.add(new ArrayList<>(input));
            return;
        }
        for (int i = curr; i < size; i++) {
            Collections.swap(input, curr, i);
            backtrace(curr + 1, input, result);
            Collections.swap(input, curr, i);
        }
    }


}
