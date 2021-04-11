package com.wt.test.leetcode.algo;

/**
 * 231. 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 *
 * @author qiyu
 * @date 2021/4/11
 */
public class Problem231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
