package com.wt.test.leetcode.algo;

/**
 * 1052. 爱生气的书店老板
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 *
 * @author qiyu
 * @date 2021/2/23
 */
public class Problem1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0)
                sum += customers[i];
        }
        int max = 0;
        int save = 0;
        for (int i = 0; i <= grumpy.length - X; i++) {
            for (int j = 0; j < X; j++) {
                if (grumpy[i + j] == 1)
                    save += customers[i + j];
            }
            if (save > max)
                max = save;
            save = 0;
        }
        return sum + max;
    }
}
