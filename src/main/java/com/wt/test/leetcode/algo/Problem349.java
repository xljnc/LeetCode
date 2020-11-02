package com.wt.test.leetcode.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @author 一贫
 * @date 2020/11/2
 */
public class Problem349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }
        Set<Integer> s2 = new HashSet<>();
        for (int j = 0; j < nums2.length; j++) {
            if (s1.contains(nums2[j]))
                s2.add(nums2[j]);
        }
        int[] result = new int[s2.size()];
        Object[] oArray = s2.toArray();
        for (int i = 0; i < oArray.length; i++) {
            result[i] = (int) oArray[i];
        }
        return result;
    }
}
