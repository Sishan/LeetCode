/*
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B[0].length;
        int nA = A[0].length;

        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < nA; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < n; j++) {
                        if (B[k][j] != 0) {
                            C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return C;
    }
}

/*
Originally, the normal way to calculate the multiplication of two metrics A, and B is as follow:
We take the the all values from the first line of A, and all values from the first column of B, and multiply the corresponding values and sum them up, the final sum is the value for the location of first column and first row in final result matrix. Similarly, the value at [ i ][ j ] of result matrix C, which is C[ i ][ j ] is calculated as:

C[ i ][ j ] = A[ i ][0]*B[0][j] + A[i][1]*B[1][j] + A[i][2]*B[2][j] + ... A[i][K]*B[K][j]
( which is the sum of each multiplication of corresponding K values from row i of A and K values from column j of B )
The Key is: if we calculate it this way, we finishing calculating the final value for the result matrix at once
Then the brute force solution is as follow:

public class Solution {
        public int[][] multiply(int[][] A, int[][] B) {
            int m = A.length, n = A[0].length, nB = B[0].length;
            int[][] C = new int[m][nB];

            for(int i = 0; i < m; i++) {
                    for (int j = 0; j < nB; j++) {
                        for(int k = 0; k < n; k++) {
                             C[i][j] += A[i][k] * B[k][j];
                        }
                    }
            }
            return C;  
        }
}
*/
