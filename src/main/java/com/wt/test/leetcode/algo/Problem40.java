package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author 一贫
 * @date 2020/9/14
 */
public class Problem40 {

    private int[] candidates;
    private int target;

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Problem40 problem40 = new Problem40();
        List<List<Integer>> result = problem40.combinationSum2(candidates, target);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //对数组排序。如果数组有序，可以去掉重复结果
        Arrays.sort(this.candidates);
        deep(0, 0, temp, result);
        return result;
    }

    public void deep(int sum, int index, List<Integer> temp, List<List<Integer>> result) {
        if (sum > target)
            return;
        if (sum == target && !result.contains(temp))
            result.add(new ArrayList<>(temp));
        else {
            for (int i = index; i < candidates.length; i++) {
                temp.add(candidates[i]);
                deep(sum + candidates[i], i + 1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
