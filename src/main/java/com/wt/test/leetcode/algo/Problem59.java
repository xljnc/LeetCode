package com.wt.test.leetcode.algo;

/**
 * 59. 螺旋矩阵 II
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * @author 一贫
 * @date 2021/3/16
 */
public class Problem59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int ax = 0, ay = 0, bx = n - 1, by = n - 1;
        fill(matrix, 1, ax, ay, bx, by);
        return matrix;
    }

    private void fill(int[][] matrix, int curr, int ax, int ay, int bx, int by) {
        if (ax > bx || ay > by)
            return;
        for (int i = ax; i <= bx; i++) {
            matrix[ay][i] = curr++;
        }
        for (int i = ay + 1; i <= by; i++) {
            matrix[i][bx] = curr++;
        }
        for (int i = bx - 1; i >= ax && ay != by; i--) {
            matrix[by][i] = curr++;
        }
        for (int i = by - 1; i >= ay + 1 && ax != bx; i--) {
            matrix[i][ax] = curr++;
        }
        ax = ax + 1;
        ay = ay + 1;
        bx = bx - 1;
        by = by - 1;
        fill(matrix, curr, ax, ay, bx, by);
    }
}
