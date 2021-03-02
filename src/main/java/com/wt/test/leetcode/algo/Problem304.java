package com.wt.test.leetcode.algo;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 *
 * @author 一贫
 * @date 2021/3/2
 */
public class Problem304 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(1, 1, 2, 1));
    }


    static class NumMatrix {

        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length > 0) {
                sum = new int[matrix.length + 1][matrix[0].length + 1];
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
        }
    }
}
