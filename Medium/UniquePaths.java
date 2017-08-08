/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        m--; // possible steps in m direction
        n--; // possible steps in n direction
        long res = 1;

        int k = Math.max(m, n); // C(m, m+n) = C(n, m+n) 
        int j = 1;

        // Total permutations = (m+n)! / (m! * n!) = [(m+1)(m+2)...(m+n)]/n!
        for (int i = k + 1; i <= m + n; i++, j++) { // Calculate C(m, m+n)
            res *= i;
            res /= j;
        }
        return (int) res;
    }
}

/*
Reference:
https://discuss.leetcode.com/topic/19613/math-solution-o-1-space
*/