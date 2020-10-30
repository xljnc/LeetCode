package com.wt.test.leetcode.algo;

/**
 * 463. 岛屿的周长
 * https://leetcode-cn.com/problems/island-perimeter/
 *
 * @author 一贫
 * @date 2020/10/30
 */
public class Problem463 {

    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int val = grid[i][j];
                if (val == 0)
                    continue;
                int topI = i - 1;
                if (topI < 0 || grid[topI][j] == 0)
                    count++;
                int bottomI = i + 1;
                if (bottomI >= grid.length || grid[bottomI][j] == 0)
                    count++;
                int leftI = j - 1;
                if (leftI < 0 || grid[i][leftI] == 0)
                    count++;
                int rightI = j + 1;
                if (rightI >= grid[i].length || grid[i][rightI] == 0)
                    count++;
            }
        }
        return count;
    }
}
