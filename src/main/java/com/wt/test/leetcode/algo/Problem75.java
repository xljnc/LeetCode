package com.wt.test.leetcode.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * @author 一贫
 * @date 2020/10/7
 */
public class Problem75 {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 0);
        counter.put(1, 0);
        counter.put(2, 0);
        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.get(nums[i]) + 1);
        }
        for (int i = 0; i < counter.get(0); i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < counter.get(1); i++) {
            nums[counter.get(0) + i] = 1;
        }
        for (int i = 0; i < counter.get(2); i++) {
            nums[counter.get(0) + counter.get(1) + i] = 2;
        }
    }
}
