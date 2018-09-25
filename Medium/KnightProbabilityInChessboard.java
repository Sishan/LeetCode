/*
On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.

Example:
Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
Note:
N will be between 1 and 25.
K will be between 0 and 100.
The knight always initially starts on the board.
*/

class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        int[] dr = new int[] { 2, 2, 1, 1, -1, -1, -2, -2 };
        int[] dc = new int[] { 1, -1, 2, -2, 2, -2, 1, -1 };

        dp[r][c] = 1;
        for (int i = 0; i < K; i++) {
            double[][] dp2 = new double[N][N];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    for (int j = 0; j < 8; j++) {
                        int fr = row + dr[j];
                        int fc = col + dc[j];
                        if (0 <= fr && fr < N && 0 <= fc && fc < N) {
                            dp2[fr][fc] += 0.125 * dp[row][col];
                        }
                    }
                }
            }
            dp = dp2;
        }

        double res = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[i][j];
            }
        }
        return res;
    }
}