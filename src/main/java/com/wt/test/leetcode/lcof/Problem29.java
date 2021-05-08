package com.wt.test.leetcode.lcof;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 *
 * @author 一贫
 * @date 2021/5/8
 */
public class Problem29 {

    private int[] result;

    private int index = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        result = new int[matrix.length * matrix[0].length];
        int ax = 0, ay = 0, bx = matrix[0].length - 1, by = matrix.length - 1;
        traverse(matrix, ax, ay, bx, by);
        return result;
    }

    private void traverse(int[][] matrix, int ax, int ay, int bx, int by) {
        if (ax > bx || ay > by)
            return;
        for (int i = ax; i <= bx; i++) {
            result[index++] = matrix[ay][i];
        }
        for (int i = ay + 1; i <= by; i++) {
            result[index++] = matrix[i][bx];
        }
        for (int i = bx - 1; i >= ax && ay != by; i--) {
            result[index++] = matrix[by][i];
        }
        for (int i = by - 1; i >= ay + 1 && ax != bx; i--) {
            result[index++] = matrix[i][ax];
        }
        ax = ax + 1;
        ay = ay + 1;
        bx = bx - 1;
        by = by - 1;
        traverse(matrix, ax, ay, bx, by);
    }
}
