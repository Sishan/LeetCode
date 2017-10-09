/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int left = 0, minLeft = 0, minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (map.containsKey(r)) { // the goal of this part is to get the first window that contains whole t
                map.put(r, map.get(r) - 1);
                if (map.get(r) >= 0) {
                    count++; // identify if the first window is found by counting frequency of the characters of t showing up in S
                }
            }

            while (count == t.length()) { // if the count is equal to the length of t, then we find such window
                if (right - left + 1 < minLen) { // //jsut update the minleft and minlen value
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // starting from the leftmost index of the window, we want to check if s[left] is in t. 
                // If so, we will remove it from the window, and increase 1 time on its counter in hashmap which means we will expect the same character later by shifting right index. At the same time, we need to reduce the size of the window due to the removal.
                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                    if (map.get(l) > 0) {
                        count--;
                    }
                }
                // if it doesn't exist in t, it is not supposed to be in the window, left++. 
                // If it does exist in t, the reason is stated as above. left++.
                left++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(minLeft, minLeft + minLen);
    }
}