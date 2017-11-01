/*
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
*/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0, i = 0, num = 0, k = 2;
        int[] count = new int[256];
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)] == 0) {
                num++;
            }
            count[s.charAt(j)]++;
            while (num > k && i < s.length()) {
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0) {
                    num--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}

/*
public String findLongestWord(String s, List<String> d) {
    Collections.sort(d, (a,b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b));
    for (String dictWord : d) {
        int i = 0;
        for (char c : s.toCharArray()) 
            if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
        if (i == dictWord.length()) return dictWord;
    }
    return "";
}
*/