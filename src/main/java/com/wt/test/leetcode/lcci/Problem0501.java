package com.wt.test.leetcode.lcci;

/**
 * 面试题 05.01. 插入
 * https://leetcode-cn.com/problems/insert-into-bits-lcci/
 *
 * @author 一贫
 * @date 2020/10/3
 */
public class Problem0501 {
    public static void main(String[] args) {
        Problem0501 problem0501 = new Problem0501();
        int result = problem0501.insertBits(1143207437,
                1017033,
                11,
                31);
        System.out.println(result);
    }

    public int insertBits(int N, int M, int i, int j) {
        long NL = N;
        long ML = M;
        long prefix = NL >> (j + 1);
        prefix = prefix << (j + 1);
        long surfix = N >> i;
        surfix <<= i;
        surfix = N - surfix;
        long addOn = M << i;
        return (int) (prefix + addOn + surfix);
    }

}
