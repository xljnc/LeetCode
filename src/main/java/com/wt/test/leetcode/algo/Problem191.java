package com.wt.test.leetcode.algo;

/**
 * 191. 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * @author 一贫
 * @date 2021/3/22
 */
public class Problem191 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
