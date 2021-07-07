package com.wt.test.leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author 一贫
 * @date 2021/7/7
 */
public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int left = target - numbers[i];
            if (map.containsKey(left)) {
                result[0] = map.get(left) + 1;
                result[1] = i + 1;
                break;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}
