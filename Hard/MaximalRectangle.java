/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int colLen = matrix[0].length;
        int rowLen = matrix.length;
        int max = 0;
        int[] h = new int[colLen + 1];
        h[colLen] = 0;

        for (int i = 0; i < rowLen; i++) {
            Stack<Integer> stk = new Stack<Integer>();
            for (int j = 0; j < colLen + 1; j++) {
                if (j < colLen) {
                    if (matrix[i][j] == '1') {
                        h[j] += 1;
                    } else {
                        h[j] = 0;
                    }
                }

                if (stk.isEmpty() || h[stk.peek()] <= h[j]) {
                    stk.push(j);
                } else {
                    while (!stk.isEmpty() && h[j] < h[stk.peek()]) {
                        int t = stk.pop();
                        max = Math.max(max, h[t] * (stk.isEmpty() ? j : j - stk.peek() - 1));
                    }
                    stk.push(j);

                }
            }
        }
        return max;
    }
}