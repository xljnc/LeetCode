package com.wt.test.leetcode.algo;

/**
 * 326. 3的幂
 * https://leetcode-cn.com/problems/power-of-three/
 *
 * @author qiyu
 * @date 2021/4/11
 */
public class Problem326 {
    public static void main(String[] args) {
        Problem326 problem326 = new Problem326();
        boolean result = problem326.isPowerOfThree(21);
        System.out.println(result);
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    public boolean isPowerOfThree1(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        if (n % 3 != 0)
            return false;
        return isPowerOfThree(n / 3);
    }
}
