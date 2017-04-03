/*
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
        state[0][0] = true;
        for (int i = 1; i < state[0].length; i++){
            if (p.charAt(i - 1) == '*'){
                if (state[0][i - 1] || state[0][i - 2]) state[0][i] = true;
            } 
        }
        
        for (int j = 0; j < s.length(); j++){
            for (int k = 0; k < p.length(); k++){
                if (p.charAt(k) == s.charAt(j) || p.charAt(k) == '.') state[j + 1][k + 1] = state[j][k];
                if (p.charAt(k) == '*'){
                    if (p.charAt(k-1) != s.charAt(j) && p.charAt(k-1) != '.') state[j+1][k+1] = state[j+1][k-1];
                    else state[j+1][k+1] = (state[j+1][k] || state[j][k+1] || state[j+1][k-1]);
                }
            }
        }
        return state[s.length()][p.length()];
    }
}


/*
1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*': 
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
Reference:
https://discuss.leetcode.com/topic/40371/easy-dp-java-solution-with-detailed-explanation
*/