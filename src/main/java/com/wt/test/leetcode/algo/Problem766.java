package com.wt.test.leetcode.algo;

/**
 * 766. 托普利茨矩阵
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 *
 * @author 一贫
 * @date 2021/2/22
 */
public class Problem766 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        Problem766 problem766 = new Problem766();
        boolean result = problem766.isToeplitzMatrix(matrix);
        System.out.println(result);
    }

    /**
     * 只要比较上一行除最后一个元素和下一行除第一个元素是否一致即可
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }
}
