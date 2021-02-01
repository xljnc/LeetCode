package com.wt.test.leetcode.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 888. 公平的糖果棒交换
 * https://leetcode-cn.com/problems/fair-candy-swap/
 *
 * @author 一贫
 * @date 2021/2/1
 */
public class Problem888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        int delta = (Arrays.stream(A).sum() - Arrays.stream(B).sum()) / 2;
        Set<Integer> set = new HashSet<>();
        Arrays.stream(A).forEach((x) -> {
            set.add(x);
        });
        int[] result = new int[2];
        for (int i : B) {
            int x = i + delta;
            if (set.contains(x)) {
                result[0] = x;
                result[1] = i;
                return result;
            }
        }
        return result;
    }
}
