package com.wt.test.leetcode.algo;

/**
 * 344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author 一贫
 * @date 2020/10/8
 */
public class Problem344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0)
            return;
        int pare = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[pare - i];
            s[pare - i] = temp;
        }
    }
}
