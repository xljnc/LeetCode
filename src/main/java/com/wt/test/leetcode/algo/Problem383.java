package com.wt.test.leetcode.algo;

/**
 * 383. 赎金信
 * https://leetcode-cn.com/problems/ransom-note/
 *
 * @author 一贫
 * @date 2021/7/13
 */
public class Problem383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        char[] charRansom = ransomNote.toCharArray();
        char[] charMagazine = magazine.toCharArray();
        for (char c : charMagazine) {
            chars[c - 'a']++;
        }
        for (char c : charRansom) {
            int index = c - 'a';
            if (chars[index] == 0)
                return false;
            chars[index]--;
        }
        return true;
    }
}
