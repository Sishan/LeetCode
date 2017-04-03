/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {                                                     //DP method
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] res = new boolean[len + 1];
        res[0] = true;
        for (int i = 1; i <= len; i++){
            for (int j = 0; j < i; j++){
                if (res[j] && wordDict.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }
}