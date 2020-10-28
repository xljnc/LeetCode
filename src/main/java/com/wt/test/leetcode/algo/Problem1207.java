package com.wt.test.leetcode.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 *
 * @author 一贫
 * @date 2020/10/28
 */
public class Problem1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer item : map.values()) {
            set.add(item);
        }
        return map.size() == set.size();
    }


}
