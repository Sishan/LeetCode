/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;

        for (int i = 0, j = 0; i < s.length(); i++){
            // if s[j] have a duplicate in the range [i,j) with index j, 
            // we don't need to increase i little by little. 
            // We can skip all the elements in the range [i, j'] and let i to be j' + 1 directly.
            if (map.containsKey(s.charAt(i)))
            {
                j = Math.max(j, map.get(s.charAt(i)) + 1); // testcase: "abba"
            }

            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}

/*
The basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, 
and keep two pointers which define the max substring. move the right pointer to scan through the string , and 
meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the 
right of the same character last found. Note that the two pointers can only move forward.
*/

/*
Complexity Analysis
Time complexity : O(n).
Space complexity (Table): O(m). m is the size of the charset.
*/