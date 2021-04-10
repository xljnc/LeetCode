package com.wt.test.leetcode.algo;

/**
 * 263. 丑数
 * https://leetcode-cn.com/problems/ugly-number/
 *
 * @author qiyu
 * @date 2021/4/10
 */
public class Problem263 {

    public static void main(String[] args) {
        Problem263 problem263 = new Problem263();
        boolean result = problem263.isUgly(14);
        System.out.println(result);
    }

    public boolean isUgly(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        if (n % 2 == 0)
            return isUgly(n / 2);
        else if (n % 3 == 0)
            return isUgly(n / 3);
        else if (n % 5 == 0)
            return isUgly(n / 5);
        return false;
    }
}
