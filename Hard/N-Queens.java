/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board, 0, res);
        return res;
    }

    public void helper(char[][] board, int colIdx, List<List<String>> res) {
        if (colIdx == board.length) {
            res.add(construct(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, colIdx, i)) {
                board[i][colIdx] = 'Q';
                helper(board, colIdx + 1, res);
                board[i][colIdx] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int colIdx, int row) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < colIdx; j++) {
                if (board[i][j] == 'Q' && (colIdx + row == i + j || colIdx + i == row + j || row == i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            String tmp = new String(board[i]);
            res.add(tmp);
        }
        return res;
    }
}