package com.wt.test.leetcode.algo;

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * @author 一贫
 * @date 2020/9/21
 */
public class Problem69 {

    public static void main(String[] args) {
        Problem69 problem69 = new Problem69();
        System.out.println(problem69.mySqrt(26));
    }

    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int left = 0;
        int right = x;
        while (left < right - 1) {
            int target = (left + right) / 2;
            if (x / target >= target)
                left = target;
            else
                right = target;
        }
        return left;
    }
}
