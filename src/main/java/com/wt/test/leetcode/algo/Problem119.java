package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 *
 * @author 一贫
 * @date 2021/2/12
 */
public class Problem119 {
    public static void main(String[] args) {
        Problem119 problem119 = new Problem119();
        List<Integer> result = problem119.getRow(3);
        System.out.println(result);
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>(rowIndex + 1);
        result.add(Arrays.asList(1));
        result.add(Arrays.asList(1, 1));
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> pre = result.get(i - 1);
            List<Integer> curr = new ArrayList<>(i + 1);
            curr.addAll(Arrays.asList(1, i));
            for (int j = 2; j < i; j++) {
                curr.add(pre.get(j) + pre.get(j - 1));
            }
            curr.add(1);
            result.add(curr);
        }
        return result.get(rowIndex);
    }
}
