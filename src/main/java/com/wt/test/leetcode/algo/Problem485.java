package com.wt.test.leetcode.algo;

/**
 * 485. 最大连续1的个数
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 *
 * @author 一贫
 * @date 2021/2/15
 */
public class Problem485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int first = -1;
        boolean found = false;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (!found) {
                    first = i;
                    found = true;
                }
            } else {
                if (found) {
                    int length = i - first;
                    max = Math.max(max, length);
                    found = false;
                }
            }
        }
        if (found == true)
            max = Math.max(max, nums.length - first);
        return max;
    }
}
