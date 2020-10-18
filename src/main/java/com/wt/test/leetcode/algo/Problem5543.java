package com.wt.test.leetcode.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * 5543. 两个相同字符之间的最长子字符串
 * https://leetcode-cn.com/contest/weekly-contest-211/problems/largest-substring-between-two-equal-characters/
 *
 * @author qiyu
 */
public class Problem5543 {

    public int maxLengthBetweenEqualCharacters(String s) {
        if (s.length() == 1)
            return -1;
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (set.contains(c))
                continue;
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(j) == c) {
                    max = Math.max(max, j - i - 1);
                    set.add(c);
                    break;
                }
            }
        }
        if (set.isEmpty())
            return -1;
        return max;
    }


}
