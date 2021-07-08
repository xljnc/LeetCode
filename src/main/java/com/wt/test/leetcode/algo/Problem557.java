package com.wt.test.leetcode.algo;

/**
 * 557. 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 *
 * @author 一贫
 * @date 2021/7/8
 */
public class Problem557 {
    public String reverseWords(String s) {
        String[] inputs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String t : inputs) {
            for (int i = t.length() - 1; i >= 0; i--) {
                sb.append(t.charAt(i));
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
