/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/

public class Solution {
    private int lo, maxLen;
    public String longestPalindrome(String s) {

        int len = s.length();
        if (s == null || len < 2) return s;
        for (int i = 0; i < len - 1; i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }
    
    public void extendPalindrome(String s, int left, int right){
        while (left >= 0  && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if (maxLen < right - left - 1){
            lo = left + 1;
            maxLen = right - left - 1;
        }
    }
}