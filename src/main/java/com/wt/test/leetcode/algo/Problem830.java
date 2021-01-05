package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830. 较大分组的位置
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 *
 * @author 一贫
 * @date 2021/1/5
 */
public class Problem830 {

    public static void main(String[] args) {
        String s = "aaa";
        Problem830 problem830 = new Problem830();
        List<List<Integer>> result = problem830.largeGroupPositions(s);
        System.out.println(result);
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        if (s.length() < 3)
            return new ArrayList<>();
        s = s + "A";
        List<List<Integer>> result = new ArrayList<>();
        int start = 0, count = 1;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c)
                count++;
            else {
                if (count >= 3)
                    result.add(Arrays.asList(start, i - 1));
                count = 1;
                c = s.charAt(i);
                start = i;
            }
        }
        return result;
    }


}
