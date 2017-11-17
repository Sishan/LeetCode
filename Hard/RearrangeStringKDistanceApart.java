/*
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:
s = "aabbcc", k = 3

Result: "abcabc"

The same letters are at least distance 3 from each other.
Example 2:
s = "aaabc", k = 3 

Answer: ""

It is not possible to rearrange the string.
Example 3:
s = "aaadbbcc", k = 2

Answer: "abacabcd"

Another possible answer is: "abcabcda"

The same letters are at least distance 2 from each other.
*/

class Solution {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        int[] valid = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            int pos = findValid(count, valid, j);
            if (pos == -1) {
                return "";
            }
            count[pos]--;
            valid[pos] = j + k;
            res.append((char) (pos + 'a'));
        }
        return res.toString();
    }

    public int findValid(int[] count, int[] valid, int pos) {
        int max = Integer.MIN_VALUE;
        int candidate = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] > max && valid[i] <= pos) {
                max = count[i];
                candidate = i;
            }
        }
        return candidate;
    }
}