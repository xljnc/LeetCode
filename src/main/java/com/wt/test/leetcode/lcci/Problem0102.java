package com.wt.test.leetcode.lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 *
 * @author 一贫
 * @date 2020/9/27
 */
public class Problem0102 {
    public static void main(String[] args) {

    }

    public boolean CheckPermutation2(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        Map<Integer, Integer> counter = new HashMap<>(16);
        for (int i = 0; i < s1.length(); i++) {
            int v = s1.charAt(i);
            if (!counter.containsKey(v))
                counter.put(v, 0);
            counter.put(v, counter.get(v) + 1);
            v = s2.charAt(i);
            if (!counter.containsKey(v))
                counter.put(v, 0);
            counter.put(v, counter.get(v) - 1);
        }
        for (Map.Entry<Integer, Integer> item : counter.entrySet()) {
            if (item.getValue() != 0)
                return false;
        }
        return true;
    }

    public boolean CheckPermutation1(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i])
                return false;
        }
        return true;
    }


}
