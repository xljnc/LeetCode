package com.wt.test.leetcode.algo;

/**
 * 832. 翻转图像
 * https://leetcode-cn.com/problems/flipping-an-image/
 *
 * @author 一贫
 * @date 2021/2/24
 */
public class Problem832 {

    public static void main(String[] args) {
        Problem832 problem832 = new Problem832();
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        problem832.flipAndInvertImage(A);
        System.out.println(A);
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (A[i].length + 1) / 2; j++) {
                int target = A[i].length - 1 - j;
                A[i][j] = A[i][j] ^ 1;
                if (j != target)
                    A[i][target] = A[i][target] ^ 1;
                int temp = A[i][j];
                A[i][j] = A[i][target];
                A[i][target] = temp;
            }
        }
        return A;
    }
}
