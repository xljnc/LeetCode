package com.wt.test.leetcode.algo;

/**
 * 37. 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 *
 * @author 一贫
 * @date 2020/9/15
 */
public class Problem37 {

    private char[][] board;

    public static void main(String[] args) {
        Problem37 problem37 = new Problem37();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        problem37.solveSudoku(board);
        System.out.println(board);
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        backtracking(0, 0);
    }

    public boolean backtracking(int row, int col) {
        int nextCol = col;
        int nextRow = row;
        nextCol++;
        if (nextCol >= 9) {
            nextCol = 0;
            nextRow++;
        }
        if (board[row][col] != '.') {
            if (nextRow >= 9)
                return true;
            boolean result = backtracking(nextRow, nextCol);
            return result;
        } else {
            for (char c = '1'; c <= '9'; c++) {
                boolean valid = check(c, row, col);
                if (valid) {
                    board[row][col] = c;
                    if (nextRow >= 9)
                        return true;
                    boolean result = backtracking(nextRow, nextCol);
                    if (!result)
                        board[row][col] = '.';
                    else
                        return result;
                }
            }
            return false;
        }
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
