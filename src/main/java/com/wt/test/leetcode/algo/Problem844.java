package com.wt.test.leetcode.algo;

/**
 * 844. 比较含退格的字符串
 * https://leetcode-cn.com/problems/backspace-string-compare/
 *
 * @author 一贫
 * @date 2020/10/19
 */
public class Problem844 {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#')
                sb.append(s.charAt(i));
            else if (sb.length() != 0)
                sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
