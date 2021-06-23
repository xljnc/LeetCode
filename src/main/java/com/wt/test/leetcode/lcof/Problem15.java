package com.wt.test.leetcode.lcof;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 * @author 一贫
 * @date 2021/6/23
 */
public class Problem15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
