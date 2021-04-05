package com.wt.test.leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author qiyu
 * @date 2021/4/5
 */
public class Problem70 {

    private Map<Integer, Integer> map = new HashMap<>();

    {
        map.put(0, 1);
        map.put(1, 1);
    }

    public int climbStairs(int n) {
        if (map.containsKey(n))
            return map.get(n);
        int a, b;
        if (map.containsKey(n - 1))
            a = map.get(n - 1);
        else {
            a = climbStairs(n - 1);
            map.put(n - 1, a);
        }
        if (map.containsKey(n - 2))
            b = map.get(n - 2);
        else {
            b = climbStairs(n - 2);
            map.put(n - 2, b);
        }
        return a + b;
    }

    public int climbStairs1(int n) {
        int a = 0, b = 0, c = 1;
        for (int i = 0; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
