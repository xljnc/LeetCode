package com.wt.test.leetcode.algo;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 解法1: 遍历+Map排序
 * 解法2:
 *
 * @author 一贫
 * @date 2020/9/7
 */
public class Problem347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] result = topKFrequent1(nums, 2);
        System.out.println(result);
    }

    /**
     * 简单粗暴流
     */
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!countMap.containsKey(nums[i]))
                countMap.put(nums[i], 0);
            countMap.put(nums[i], countMap.get(nums[i]) + 1);
        }
        List<Map.Entry<Integer, Integer>> countList = new ArrayList<>(countMap.entrySet());
        Collections.sort(countList, (x, y) -> {
            return 0 - x.getValue().compareTo(y.getValue());
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = countList.get(i).getKey();
        }
        return result;
    }
}
