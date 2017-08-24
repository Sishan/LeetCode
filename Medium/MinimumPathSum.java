/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (i == 0 && j == 0){
                    grid[i][j] = grid[i][j];
                }
                else if (i == 0 && j != 0){
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                else if (i != 0 && j == 0){
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                else{
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[row - 1][col - 1];
    }
}