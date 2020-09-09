package com.wt.test.leetcode.algo;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 解法一: 循环替换"()"，"[]","{}",如果最终剩下的为"",返回true
 * 解法二: 栈
 *
 * @author 一贫
 * @date 2020/9/9
 */
public class Problem20 {

    public static void main(String[] args) {

    }

    public static boolean isValid2(String s) {
        //TODO
        return false;
    }

    public static boolean isValid1(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.equals("");
    }
}
