package com.wt.test.leetcode.algo;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author 一贫
 * @date 2020/12/23
 */
public class Problem387 {
    public static void main(String[] args) {
        Problem387 problem387 = new Problem387();
        problem387.firstUniqChar("leetcode");
    }

    public int firstUniqChar(String s) {
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

}
