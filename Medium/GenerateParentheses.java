/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) return res;
        backTrack(res, "", 0, 0, n);
        return res;
    }
    
    public void backTrack(List<String> res, String tmp, int open, int close, int max){
        if (tmp.length() == max * 2){
            res.add(tmp);
            return;
        }
        if (open < max){
            backTrack(res, tmp + "(", open + 1, close, max);
        }
        if (close < open){
            backTrack(res, tmp + ")", open, close + 1, max);
        }
    }
}