package com.wt.test.leetcode.algo;

/**
 * 941. 有效的山脉数组
 * https://leetcode-cn.com/problems/valid-mountain-array/
 *
 * @author 一贫
 * @date 2020/11/3
 */
public class Problem941 {

    public static void main(String[] args) {
        Problem941 problem941 = new Problem941();
        int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(problem941.validMountainArray(A));
    }

    public boolean validMountainArray(int[] A) {
        if (A.length < 3)
            return false;
        int i = 0;
        while (i < A.length - 1 && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == A.length - 1)
            return false;
        while (i < A.length - 1 && A[i] > A[i + 1]) {
            i++;
        }
        return i == A.length - 1;
    }
}
