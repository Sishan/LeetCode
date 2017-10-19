/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/

class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] map = new int[26];
        int pos = 0;

        // Record frequency for each char
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;                        // record the smallest char
            }
            if (--map[s.charAt(i) - 'a'] == 0) {
                break;                          // if frequency == 1, break
            }
        }
        return s.length() == 0 ? ""
                : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}