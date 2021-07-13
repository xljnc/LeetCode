package com.wt.test.leetcode.algo;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author 一贫
 * @date 2021/7/13
 */
public class Problem242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] temp = new int[26];
        for (char c : cs) {
            temp[c - 'a']++;
        }
        for (char c : ct) {
            temp[c - 'a']--;
        }
        for (int i : temp) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
