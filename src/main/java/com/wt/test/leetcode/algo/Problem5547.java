package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5547. 等差子数组 显示英文描述
 * https://leetcode-cn.com/contest/weekly-contest-212/problems/arithmetic-subarrays/
 *
 * @author 一贫
 * @date 2020/10/25
 */
public class Problem5547 {
    public static void main(String[] args) {
        Problem5547 problem5547 = new Problem5547();
        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0, 0, 2};
        int[] r = {2, 3, 5};
        List<Boolean> result = problem5547.checkArithmeticSubarrays(nums, l, r);
        System.out.println(result);
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>(l.length);
        for (int i = 0; i < l.length; i++) {
            int[] digits = new int[r[i] - l[i] + 1];
            for (int j = 0; j < digits.length; j++) {
                digits[j] = nums[j + l[i]];
            }
            result.add(judge(digits));
        }
        return result;
    }

    private boolean judge(int[] digits) {
        Arrays.sort(digits);
        int diff = digits[1] - digits[0];
        for (int i = 2; i < digits.length; i++) {
            if (digits[i] - digits[i - 1] != diff)
                return false;
        }
        return true;
    }
}
