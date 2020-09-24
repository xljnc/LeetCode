package com.wt.test.leetcode.lcci;

/**
 * 面试题 01.09. 字符串轮转
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 *
 * @author 一贫
 * @date 2020/9/24
 */
public class Problem0109 {

    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s2).contains(s1);
    }
}
