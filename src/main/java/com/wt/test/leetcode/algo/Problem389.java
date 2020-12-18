package com.wt.test.leetcode.algo;

/**
 * 389. 找不同
 * https://leetcode-cn.com/problems/find-the-difference/
 *
 * @author 一贫
 * @date 2020/12/18
 */
public class Problem389 {
    public static void main(String[] args) {
        Problem389 problem389 = new Problem389();
        String s = "abcd", t = "abcde";
        char result = problem389.findTheDifference(s, t);
        System.out.println(result);
    }

    public char findTheDifference(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

    public char findTheDifference1(String s, String t) {
        int sc = 0, tc = 0;
        for (int i = 0; i < s.length(); i++) {
            sc += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            tc += t.charAt(i);
        }
        return (char) (tc - sc);
    }
}
