package com.wt.test.leetcode.algo;

/**
 * 977. 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * @author 一贫
 * @date 2020/10/16
 */
public class Problem977 {

    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        if (A.length == 1)
            result[0] = A[0] * A[0];
        else if (A[0] >= 0) {
            for (int i = 0; i < A.length; i++) {
                result[i] = A[i] * A[i];
            }
        } else if (A[A.length - 1] <= 0) {
            for (int i = A.length - 1; i >= 0; i--) {
                result[A.length - i - 1] = A[i] * A[i];
            }
        } else {
            int positive = -1;
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= 0) {
                    positive = i;
                    break;
                }
            }
            int negative = positive - 1;
            int curr = 0;
            while (negative >= 0 && positive < A.length) {
                if (Math.abs(A[negative]) < Math.abs(A[positive])) {
                    result[curr++] = A[negative] * A[negative];
                    negative--;
                } else {
                    result[curr++] = A[positive] * A[positive];
                    positive++;
                }
            }
            while (negative >= 0) {
                result[curr++] = A[negative] * A[negative];
                negative--;
            }
            while (positive < A.length) {
                result[curr++] = A[positive] * A[positive];
                positive++;
            }
        }
        return result;
    }
}
