package com.wt.test.leetcode.algo;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author 一贫
 * @date 2020/9/24
 */
public class Problem50 {

    public static void main(String[] args) {
        Problem50 problem50 = new Problem50();
        System.out.println(problem50.myPow(2.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        long N = n;
        N = Math.abs(N);
        double result = 1.0D;
        double contributor = x;
        while (N > 0) {
            if (N % 2D == 1)
                result *= contributor;
            contributor *= contributor;
            N /= 2D;
        }
        return n < 0 ? (1.0D / result) : result;
    }
}
