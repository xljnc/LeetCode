package com.wt.test.leetcode.algo;

/**
 * 566. 重塑矩阵
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 *
 * @author 一贫
 * @date 2021/7/13
 */
public class Problem566 {
    public static void main(String[] args) {
        Problem566 problem566 = new Problem566();
        int[][] mat = {{1, 2}, {3, 4}};
        problem566.matrixReshape(mat, 1, 4);
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c)
            return mat;
        int[][] result = new int[r][c];
        int currR = 0, currC = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (currC == mat[0].length) {
                    currC = 0;
                    currR++;
                }
                result[i][j] = mat[currR][currC++];
            }
        }
        return result;
    }
}
