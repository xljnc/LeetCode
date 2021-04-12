package com.wt.test.leetcode.algo;

import java.util.Arrays;

/**
 * 179. 最大数
 * https://leetcode-cn.com/problems/largest-number/
 *
 * @author qiyu
 */
public class Problem179 {

    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            String sa = String.valueOf(a);
            String sb = String.valueOf(b);
            Long ca = Long.valueOf(sa + sb);
            Long cb = Long.valueOf(sb + sa);
            return cb.compareTo(ca);
        });
        StringBuilder sb = new StringBuilder();
        for (Integer x : arr) {
            sb.append(x);
        }
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;
    }
}
