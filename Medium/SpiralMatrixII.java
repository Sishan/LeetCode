/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n <= 0)
            return res;
        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int num = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                res[rowStart][j] = num++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = num++;
            }
            colEnd--;

            for (int j = colEnd; j >= colStart; j--) {
                if (rowStart <= rowEnd) {
                    res[rowEnd][j] = num++;
                }
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--) {
                if (colStart <= colEnd) {
                    res[i][colStart] = num++;
                }
            }
            colStart++;
        }
        return res;
    }
}