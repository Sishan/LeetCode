/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<String>();
        backTrack(s, 0, cur, res);
        return res;
    }

    public void backTrack(String s, int pos, List<String> cur, List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(cur));
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(s, pos, i)) {
                cur.add(s.substring(pos, i + 1));
                backTrack(s, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}