/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int i, int j, char[] word, int start) {
        if (start == word.length)
            return true;
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1)
            return false;
        if (board[i][j] != word[start])
            return false;
        board[i][j] ^= 256;
        boolean isExist = (helper(board, i + 1, j, word, start + 1) || helper(board, i, j + 1, word, start + 1)
                || helper(board, i - 1, j, word, start + 1) || helper(board, i, j - 1, word, start + 1));
        board[i][j] ^= 256;
        return isExist;
    }
}