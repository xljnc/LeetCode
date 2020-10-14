package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. 查找常用字符
 * https://leetcode-cn.com/problems/find-common-characters/
 *
 * @author 一贫
 * @date 2020/10/14
 */
public class Problem1002 {
    public static void main(String[] args) {
        Problem1002 problem1002 = new Problem1002();
        String[] A = {"bella", "label", "roller"};
        List<String> result = problem1002.commonChars(A);
        System.out.println(result);
    }

    public List<String> commonChars(String[] A) {
        int[] counter = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            counter[A[0].charAt(i) - 'a'] += 1;
        }
        int[] temp;
        for (int i = 1; i < A.length; i++) {
            temp = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                temp[A[i].charAt(j) - 'a'] += 1;
            }
            for (int j = 0; j < 26; j++) {
                counter[j] = Math.min(counter[j], temp[j]);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < counter.length; i++) {
            for (int j = 0; j < counter[i]; j++) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }
        return result;
    }
}
