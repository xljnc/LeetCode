package com.wt.test.leetcode.lcci;

/**
 * 面试题 05.06. 整数转换
 * https://leetcode-cn.com/problems/convert-integer-lcci/
 *
 * @author 一贫
 * @date 2021/6/30
 */
public class Problem0506 {
    public int convertInteger(int A, int B) {
        int x = A ^ B;
        return Integer.bitCount(x);
    }
}
