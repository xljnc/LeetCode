package com.wt.test.leetcode.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. 有效的数独
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * @author 一贫
 * @date 2020/9/22
 */
public class Problem36 {

    private char[][] board;

    public static void main(String[] args) {
        Problem36 problem36 = new Problem36();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean result = problem36.isValidSudoku(board);
        System.out.println(result);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] cols = new HashSet[9];
        Set<Integer>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>(16);
            cols[i] = new HashSet<>(16);
            boxes[i] = new HashSet<>(16);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = (int) c;
                    if (rows[i].contains(n))
                        return false;
                    rows[i].add(n);
                    if (cols[j].contains(n))
                        return false;
                    cols[j].add(n);
                    int index = i / 3 * 3 + j / 3;
                    if (boxes[index].contains(n))
                        return false;
                    boxes[index].add(n);
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                if (row[i][c - '1'] != 0)
                    return false;
                row[i][c - '1'] = 1;
                if (col[j][c - '1'] != 0)
                    return false;
                col[j][c - '1'] = 1;
                int index = i / 3 * 3 + j / 3;
                if (box[index][c - '1'] != 0)
                    return false;
                box[index][c - '1'] = 1;
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                boolean result = check(board[i][j], i, j);
                if (!result)
                    return result;
            }
        }
        return true;
    }

    public boolean check(char value, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (row == i)
                continue;
            if (board[i][col] == value)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (col == i)
                continue;
            if (board[row][i] == value)
                return false;
        }
        int rowStart = row - row % 3;
        int rowEnd = rowStart + 2;
        int colStart = col - col % 3;
        int colEnd = colStart + 2;
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (i == row && j == col)
                    continue;
                if (board[i][j] == value)
                    return false;
            }
        }
        return true;
    }
}
