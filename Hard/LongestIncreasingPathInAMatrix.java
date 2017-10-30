/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
*/

class Solution {
    final int[][] direction = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int longestIncreasingPath(int[][] matrix) {
        int res = 1;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int max = dfs(matrix, i, j, cache);
                res = Math.max(res, max);
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int rowIdx, int colIdx, int[][] cache) {
        if (cache[rowIdx][colIdx] != 0) {
            return cache[rowIdx][colIdx];
        }
        int max = 1;
        for (int[] dir : direction) {
            int newRow = rowIdx + dir[0];
            int newCol = colIdx + dir[1];
            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length
                    || matrix[newRow][newCol] <= matrix[rowIdx][colIdx]) {
                continue;
            }
            int len = 1 + dfs(matrix, newRow, newCol, cache);
            max = Math.max(max, len);
        }
        cache[rowIdx][colIdx] = max;
        return max;
    }
}