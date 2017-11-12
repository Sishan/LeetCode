/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/

class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int d) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) {
            return;
        }
        rooms[i][j] = d;
        dfs(rooms, i - 1, j, d + 1);
        dfs(rooms, i + 1, j, d + 1);
        dfs(rooms, i, j - 1, d + 1);
        dfs(rooms, i, j + 1, d + 1);
    }
}

/*
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < rooms.length; i ++){
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int[] dir : direction){
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];

                if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length) {
                    continue;
                }
                if (rooms[row][col] == -1){
                    continue;
                }
                if (rooms[row][col] == Integer.MAX_VALUE){
                    rooms[row][col] = rooms[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{row, col});
                }
            }
        }
    }
}
*/