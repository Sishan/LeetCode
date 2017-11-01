/*
Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.

The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.


After the rain, water are trapped between the blocks. The total volume of water trapped is 4.
*/

class Solution {

    class Cell {
        private int row;
        private int col;
        private int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) {
            return 0;
        }
        
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(new Comparator<Cell>() {
            @Override
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        // Add all boundary into the queue
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            queue.add(new Cell(0, i, heightMap[0][i]));
            visited[m - 1][i] = true;
            queue.add(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        for (int j = 0; j < m; j++) {
            visited[j][0] = true;
            queue.add(new Cell(j, 0, heightMap[j][0]));
            visited[j][n - 1] = true;
            queue.add(new Cell(j, n - 1, heightMap[j][n - 1]));
        }

        int res = 0;
        int[][] direction = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        // BFS
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int[] dir : direction) {
                int row = cur.row + dir[0];
                int col = cur.col + dir[1];
                if (col >= 0 && col < n && row >= 0 && row < m && !visited[row][col]) {
                    visited[row][col] = true;
                    // if the neighbourhood cell is lower, then it will be at least hold cur.height - heightMap[row][col] water
                    res += Math.max(0, cur.height - heightMap[row][col]);
                    // if the neighbourhood cell is lower, repalce its height with the cur.height
                    queue.offer(new Cell(row, col, Math.max(cur.height, heightMap[row][col])));
                }
            }
        }
        return res;
    }
}