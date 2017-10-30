/*
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
*/

class Solution {
    private int[][] direction = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<int[]>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int row = matrix.length, col = matrix[0].length;
        
        boolean[][] pac = new boolean[row][col];
        boolean[][] alt = new boolean[row][col];
        Queue<int[]> pacFlow = new LinkedList<int[]>();
        Queue<int[]> altFlow = new LinkedList<int[]>();
        
        for (int i = 0; i < row; i++){
            pac[i][0] = true;
            alt[i][col - 1] = true;
            pacFlow.offer(new int[]{i, 0});
            altFlow.offer(new int[]{i, col - 1});
        }
        
        for (int j = 0; j < col; j++){
            pac[0][j] = true;
            alt[row - 1][j] = true;
            pacFlow.offer(new int[]{0, j});
            altFlow.offer(new int[]{row - 1, j});
        }
        
        BFS(matrix, pacFlow, pac);
        BFS(matrix, altFlow, alt);
        
        for (int m = 0; m < row; m++){
            for (int n = 0; n < col; n++){
                if (pac[m][n] && alt[m][n]){
                    res.add(new int[]{m, n});
                }
            }
        }
        return res;
    }
    
    public void BFS(int[][] matrix, Queue<int[]> flow, boolean[][] visited){
        int row = matrix.length, col = matrix[0].length;
        while(!flow.isEmpty()){
            int[] cur = flow.poll();
            for (int[] dir : direction){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= row || y < 0 || y >= col || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                flow.offer(new int[]{x, y});
            }
        }
    }
}