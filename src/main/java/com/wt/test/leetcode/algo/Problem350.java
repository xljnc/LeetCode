package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * @author 一贫
 * @date 2021/7/8
 */
public class Problem350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if (l1 > l2) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int count = map.getOrDefault(nums1[i], 0);
            map.put(nums1[i], count + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count == 0)
                continue;
            list.add(i);
            map.put(i, count - 1);
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (Integer i : list) {
            result[index++] = i;
        }
        return result;
    }
}
