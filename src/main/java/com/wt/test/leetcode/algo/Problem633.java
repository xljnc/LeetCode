package com.wt.test.leetcode.algo;

/**
 * 633. 平方数之和
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 *
 * @author 一贫
 * @date 2021/4/28
 */
public class Problem633 {

    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            int count = a * a + b * b;
            if (count == c)
                return true;
            if (count < c)
                a++;
            if (count > c)
                b--;
        }
        return false;
    }
}
