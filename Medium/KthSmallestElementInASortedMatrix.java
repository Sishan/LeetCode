/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

class Solution {
    class Pair {
        int x;
        int y;
        int val;

        public Pair(int _x, int _y, int _val) {
            x = _x;
            y = _y;
            val = _val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = martix[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.val - b.val);
        for (int i = 0; i < m; i++) {
            pq.offer(new Pair(0, i, matrix[0][i]));
        }
        for (int j = 0; j < k - 1; j++) {
            Pair cur = pq.poll();
            if (cur.x == n - 1) {
                continue;
            }
            pq.offer(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        }

        Pair kth = pq.poll();
        return matrix[kth.x][kth.y];
    }
}