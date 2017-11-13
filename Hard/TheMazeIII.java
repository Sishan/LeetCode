/*
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.

Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (0, 1)

Output: "lul"
Explanation: There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".

Example 2

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (3, 0)
Output: "impossible"
Explanation: The ball cannot reach the hole.

Note:
There is only one ball and one hole in the maze.
Both the ball and hole exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.
*/

class Solution {
    class Point implements Comparable<Point> {
        int row;
        int col;
        int len;
        String route;

        public Point(int x, int y) {
            row = x;
            col = y;
            len = Integer.MAX_VALUE;
            route = "";
        }

        public Point(int x, int y, int l, String s) {
            row = x;
            col = y;
            len = l;
            route = s;
        }

        public int compareTo(Point p) {
            return len == p.len ? route.compareTo(p.route) : len - p.len;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        Point[][] points = new Point[m][n];
        for (int i = 0; i < m * n; i++) {
            points[i / n][i % n] = new Point(i / n, i % n);
        }
        PriorityQueue<Point> queue = new PriorityQueue<Point>();
        queue.offer(new Point(ball[0], ball[1], 0, ""));
        int[][] direction = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        String[] directionList = new String[] { "u", "r", "d", "l" };
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (points[cur.row][cur.col].compareTo(cur) <= 0) {
                continue;
            }
            points[cur.row][cur.col] = cur;
            for (int i = 0; i < direction.length; i++) {
                int newRow = cur.row;
                int newCol = cur.col;
                int newLen = cur.len;
                while (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == 0
                        && (newRow != hole[0] || newCol != hole[1])) {
                    newRow += direction[i][0];
                    newCol += direction[i][1];
                    newLen++;
                }
                if (newRow != hole[0] || newCol != hole[1]) {
                    newRow -= direction[i][0];
                    newCol -= direction[i][1];
                    newLen--;
                }
                queue.offer(new Point(newRow, newCol, newLen, cur.route + directionList[i]));
            }
        }
        return points[hole[0]][hole[1]].len == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].route;
    }
}