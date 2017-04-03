/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class Solution {
    public int numTrees(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int len = 2; len <= n; len++){
            for (int root = 1; root <= len; root++){
                dp[len] += dp[root - 1] * dp[len - root];
            }
        }
        return dp[n];
    }
}

/*
DP method, using the fact that dp[len] += dp[root - 1] * dp[len - root]
Reference:
https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
*/