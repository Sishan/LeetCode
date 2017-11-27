/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

class Solution {
    public int numDistinct(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        int[][] dp = new int[tl + 1][sl + 1];
        for (int i = 0; i <= sl; i++) {
            dp[0][i] = 1;

        }

        for (int i = 1; i <= tl; i++) {
            for (int j = 1; j <= sl; j++) {
                if (t.charAt(i - 1) != s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[tl][sl];
    }
}