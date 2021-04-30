package com.wt.test.leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * https://leetcode-cn.com/problems/single-number-ii/
 *
 * @author 一贫
 * @date 2021/4/30
 */
public class Problem137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer count = map.getOrDefault(i, 0);
            if (count <= 1)
                map.put(i, count + 1);
            else
                map.remove(i);
        }
        for (int i : map.keySet()) {
            return i;
        }
        return 0;
    }
}
