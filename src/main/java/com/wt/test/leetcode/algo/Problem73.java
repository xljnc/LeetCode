package com.wt.test.leetcode.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 *
 * @author 一贫
 * @date 2021/7/9
 */
public class Problem73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i : rows) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i : cols) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }
    }
}
