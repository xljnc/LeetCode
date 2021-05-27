package com.wt.test.leetcode.algo;

/**
 * 461. 汉明距离
 * https://leetcode-cn.com/problems/hamming-distance/
 *
 * @author 一贫
 * @date 2021/5/27
 */
public class Problem461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
