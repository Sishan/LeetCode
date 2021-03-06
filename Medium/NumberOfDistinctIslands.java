/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.
Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.

Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.
Note: The length of each dimension in the given grid does not exceed 50.
*/

class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<List<List<Integer>>> islands = new HashSet<List<List<Integer>>>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<List<Integer>> island = new ArrayList<List<Integer>>();
                    dfs(grid, i, j, i, j, island);
                    islands.add(island);
                }
            }
        }
        return islands.size();
    }

    public void dfs(int[][] grid, int i0, int j0, int i, int j, List<List<Integer>> island) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= 0) {
            return;
        }
        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        if (grid[i][j] == 1) {
            grid[i][j] *= -1;
            island.add(Arrays.asList(i - i0, j - j0));
            for (int[] dir : directions) {
                dfs(grid, i0, j0, i + dir[0], j + dir[1], island);
            }
        }
    }
}