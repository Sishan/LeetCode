/*
Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
*/

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (words == null || words.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) { //Note j <= words[i].length(), handle empty string in the input.                 
                String s1 = words[i].substring(0, j);      //Consider the test case of ["a", ""]
                String s2 = words[i].substring(j);

                if (isPalidrome(s1)) {
                    s2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2) && map.get(s2) != i) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(map.get(s2));
                        tmp.add(i);
                        res.add(tmp);
                    }
                }

                if (isPalidrome(s2)) {
                    s1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1) && map.get(s1) != i && s2.length() != 0) {  //Avoid duplicates, consider test case ["abcd", "dcba"]
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(i);
                        tmp.add(map.get(s1));
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalidrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}