package com.wt.test.leetcode.algo;

/**
 * 896. 单调数列
 * https://leetcode-cn.com/problems/monotonic-array/
 *
 * @author qiyu
 * @date 2021/2/28
 */
public class Problem896 {

    public boolean isMonotonic(int[] A) {
        boolean up = true;
        boolean down = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1])
                up = false;
            if (A[i] > A[i - 1])
                down = false;
            if ((!up) && (!down))
                return false;
        }
        return true;
    }
}
