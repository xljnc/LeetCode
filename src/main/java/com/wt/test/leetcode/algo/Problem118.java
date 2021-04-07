package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 *
 * @author qiyu
 * @date 2021/4/5
 */
public class Problem118 {

    public static void main(String[] args) {
        Problem118 problem118 = new Problem118();
        List<List<Integer>> result = problem118.generate(5);
        System.out.println(result);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows == 1)
            result.add(Arrays.asList(1));
        else if (numRows == 2) {
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1, 1));
        } else {
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1, 1));
            for (int i = 2; i < numRows; i++) {
                List<Integer> pre = result.get(i - 1);
                List<Integer> curr = new ArrayList<>(i + 1);
                curr.add(1);
                for (int j = 1; j < i; j++) {
                    curr.add(pre.get(j) + pre.get(j - 1));
                }
                curr.add(1);
                result.add(curr);
            }
        }
        return result;
    }
}
