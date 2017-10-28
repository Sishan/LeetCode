/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
*/

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    int sum = 0;

                    int left = j - 1;
                    while (left >= 0 && grid[i][left] != 'W') {
                        if (grid[i][left] == 'E') {
                            sum++;
                        }
                        left--;
                    }

                    int right = j + 1;
                    while (right < grid[0].length && grid[i][right] != 'W') {
                        if (grid[i][right] == 'E') {
                            sum++;
                        }
                        right++;
                    }

                    int up = i - 1;
                    while (up >= 0 && grid[up][j] != 'W') {
                        if (grid[up][j] == 'E') {
                            sum++;
                        }
                        up--;
                    }

                    int down = i + 1;
                    while (down < grid.length && grid[down][j] != 'W') {
                        if (grid[down][j] == 'E') {
                            sum++;
                        }
                        down++;
                    }

                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }
}