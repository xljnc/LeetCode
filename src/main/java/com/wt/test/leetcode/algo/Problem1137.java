package com.wt.test.leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 1137. 第 N 个泰波那契数
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 *
 * @author 一贫
 * @date 2021/7/5
 */
public class Problem1137 {
    private static final Map<Integer, Integer> memo = new HashMap<>(64);

    public int tribonacci(int n) {
        if (memo.containsKey(n))
            return memo.get(n);
        if (n == 0) {
            memo.putIfAbsent(0, 0);
            return 0;
        }
        if (n == 1) {
            memo.putIfAbsent(1, 1);
            return 1;
        }
        if (n == 2) {
            memo.putIfAbsent(2, 1);
            return 1;
        }
        int result = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        memo.putIfAbsent(n, result);
        return result;
    }

}
