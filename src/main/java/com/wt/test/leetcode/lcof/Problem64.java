package com.wt.test.leetcode.lcof;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * @author 一贫
 * @date 2021/2/7
 */
public class Problem64 {

    /**
     * 递归
     */
    public int sumNums(int n) {
        if (n == 1)
            return 1;
        return n + sumNums(n - 1);
    }

}
