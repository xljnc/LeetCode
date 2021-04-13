package com.wt.test.leetcode.algo;

/**
 * 342. 4的幂
 * https://leetcode-cn.com/problems/power-of-four/
 *
 * @author qiyu
 * @date 2021/4/11
 */
public class Problem342 {

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public boolean isPowerOfFour1(int n) {
        return n > 0 && Integer.toString(n, 4).matches("^10*$");
    }
}
