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
    int start, maxLen;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (s == null) return null;
        if (len < 2) return s;
        for (int i = 0; i + 1 < len; i++){
            extendPal(s, i, i);
            extendPal(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }
    
    public void extendPal(String input, int left, int right){
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)){  // remove left and right point out of range here
            left--;
            right++;
        }
        if (right - left - 1 > maxLen){
            maxLen = right - left - 1;
            start = left + 1;
        }
    }
}