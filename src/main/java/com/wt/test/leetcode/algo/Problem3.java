package com.wt.test.leetcode.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author 一贫
 * @date 2020/9/4
 */
public class Problem3 {

    public static void main(String[] args) {
        String input = "";
        int result = lengthOfLongestSubstring(input);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.length() - i) < max)
                return max;
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int j;
            for (j = i + 1; j < s.length(); j++) {
                if (!set.add(s.charAt(j)))
                    break;
            }
            int length = j - i;
            max = Math.max(max, length);
        }
        return max;
    }

}
