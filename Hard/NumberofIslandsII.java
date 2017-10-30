/*

A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?
*/

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if (m <= 0 || n <= 0) {
            return res;
        }
        int[] root = new int[m * n]; // union found array
        Arrays.fill(root, -1); // set initial value = -1
        int count = 0;
        int[][] direction = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int[] pos : positions) {
            int id = n * pos[0] + pos[1]; // convert postion to unique id
            root[id] = id; // assign root 
            count++;

            for (int[] dir : direction) {
                int nbX = pos[0] + dir[0];
                int nbY = pos[1] + dir[1];
                int nbId = n * nbX + nbY; // calculate id of neighborhood
                if (nbX < 0 || nbX >= m || nbY < 0 || nbY >= n || root[nbId] == -1) {
                    continue;
                }
                int nbRoot = findRoot(root, nbId);
                if (nbRoot != id) {
                    root[id] = nbRoot; // union two island
                    id = nbRoot; // current tree root = joined tree root
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    public int findRoot(int[] root, int id) {
        while (root[id] != id) {
            id = root[id];
        }
        return id;
    }
}