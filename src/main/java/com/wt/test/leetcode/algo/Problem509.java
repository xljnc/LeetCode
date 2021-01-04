package com.wt.test.leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author 一贫
 * @date 2021/1/4
 */
public class Problem509 {

    private static final Map<Integer, Integer> memo = new HashMap<Integer, Integer>(64);

    public int fib(int n) {
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
        int result = fib(n - 1) + fib(n - 2);
        memo.putIfAbsent(n, result);
        return result;
    }

    public int fib1(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib1(n - 1) + fib1(n - 2);
    }
}
