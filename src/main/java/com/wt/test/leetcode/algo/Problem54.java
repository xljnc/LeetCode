package com.wt.test.leetcode.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author 一贫
 * @date 2021/3/15
 */
public class Problem54 {

    public static void main(String[] args) {
        Problem54 problem54 = new Problem54();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> result = problem54.spiralOrder(matrix);
        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        int ax = 0, ay = 0, bx = matrix[0].length - 1, by = matrix.length - 1;
        traverse(matrix, result, ax, ay, bx, by);
        return result;
    }

    private void traverse(int[][] matrix, List<Integer> result, int ax, int ay, int bx, int by) {
        if (ax > bx || ay > by)
            return;
        for (int i = ax; i <= bx; i++) {
            result.add(matrix[ay][i]);
        }
        for (int i = ay + 1; i <= by; i++) {
            result.add(matrix[i][bx]);
        }
        for (int i = bx - 1; i >= ax && ay != by; i--) {
            result.add(matrix[by][i]);
        }
        for (int i = by - 1; i >= ay + 1 && ax != bx; i--) {
            result.add(matrix[i][ax]);
        }
        ax = ax + 1;
        ay = ay + 1;
        bx = bx - 1;
        by = by - 1;
        traverse(matrix, result, ax, ay, bx, by);
    }
}
