/*
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
*/

class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        final int[] shift = new int[] { 0, 1, 0, -1, 0 }; // to explore BFS
        int row = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];   // record the distance to all 0
        int[][] reach = new int[row][col];      // record how many buildings can be reached
        int buildingNum = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.offer(new int[] { i, j });
                    boolean[][] isVisited = new boolean[row][col];
                    int level = 1;  // initial distance
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] cur = queue.poll();

                            for (int s = 0; s < 4; s++) {
                                int newRow = cur[0] + shift[s];
                                int newCol = cur[1] + shift[s + 1];
                                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col
                                        && grid[newRow][newCol] == 0 && !isVisited[newRow][newCol]) {
                                    distance[newRow][newCol] += level;
                                    reach[newRow][newCol]++;
                                    isVisited[newRow][newCol] = true;
                                    queue.offer(new int[] { newRow, newCol });
                                }
                            }
                        }
                        level++; 
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                if (grid[m][n] == 0 && reach[m][n] == buildingNum) {
                    res = Math.min(res, distance[m][n]); // find shortest distance
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}