package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author 一贫
 * @date 2020/9/9
 */
public class Problem39 {

    private int[] candidates;
    private int target;

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Problem39 problem39 = new Problem39();
        List<List<Integer>> result = problem39.combinationSum(candidates, target);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                temp.add(candidates[i]);
                //由于数组有序，则递归，从自身开始
                deep(sum + candidates[i], i, temp, result);
                //去掉自身，然后从下一个继续递归查找
                temp.remove(temp.size() - 1);
            }
        }
    }
}
