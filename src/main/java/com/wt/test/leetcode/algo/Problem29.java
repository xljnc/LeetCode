package com.wt.test.leetcode.algo;

/**
 * 29. 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 *
 * @author 一贫
 * @date 2020/9/11
 */
public class Problem29 {

    public static void main(String[] args) {
//        System.out.println(divide1(-2147483648,-2));
        System.out.println(divide2(-2147483648, -2));
    }

    /**
     * 使用Math.log和Math.exp绕开限制
     */
    public static int divide2(int dividend, int divisor) {
        if (divisor == 1)
            return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        double did = Math.abs((double) dividend);
        double div = Math.abs((double) divisor);
        double log = Math.log(did) - Math.log(div);
        int exp = (int) Math.exp(log);
        return negative ? 0 - exp : exp;

    }

    /**
     * 使用减法
     */
    public static int divide1(int dividend, int divisor) {
        if (divisor == 1)
            return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long did = dividend;
        long div = divisor;
        if (did < 0)
            did = 0 - did;
        if (div < 0)
            div = 0 - div;
        int count = 0;
        while (did >= div) {
            count++;
            did = did - div;
        }
        return negative ? 0 - count : count;
    }
}
