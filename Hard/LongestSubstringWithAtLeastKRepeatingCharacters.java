/*
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int i = 0; i <= 26; i++) { // unique number of characters in the substring
            res = Math.max(res, helper(s, k, i));
        }
        return res;
    }

    public int helper(String s, int k, int uniqueTarget) { // uniqueTarget helps to remove begin to the right
        int[] map = new int[256];
        int unique = 0;
        int noLessThanK = 0;
        int start = 0, end = 0;
        int len = 0;
        while (end < s.length()) {
            if (map[s.charAt(end)] == 0) {
                unique++;
            }
            map[s.charAt(end)]++;
            if (map[s.charAt(end)] == k) {
                noLessThanK++;
            }
            end++;
            while (unique > uniqueTarget) {
                if (map[s.charAt(start)] == k) {
                    noLessThanK--;
                }

                map[s.charAt(start)]--;
                if (map[s.charAt(start)] == 0) {
                    unique--;
                }
                start++;
            }
            if (unique == uniqueTarget && unique == noLessThanK) {
                len = Math.max(end - start, len);
            }
        }
        return len;
    }
}