/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
*/


public class Solution {
    // sliding window
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
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
   public class Solution {
        public int lengthOfLongestSubstringKDistinct(String str, int k) {
            if (str == null || str.isEmpty() || k == 0) {
                return 0;
            }
            TreeMap<Integer, Character> lastOccurrence = new TreeMap<>();
            Map<Character, Integer> inWindow = new HashMap<>();
            int j = 0;
            int max = 1;
            for (int i = 0; i < str.length(); i++) {
                char in = str.charAt(i);
                while (inWindow.size() == k && !inWindow.containsKey(in)) {
                    int first = lastOccurrence.firstKey();
                    char out = lastOccurrence.get(first);
                    inWindow.remove(out);
                    lastOccurrence.remove(first);
                    j = first + 1;
                }
                //update or add in's position in both maps
                if (inWindow.containsKey(in)) {
                    lastOccurrence.remove(inWindow.get(in));
                }
                inWindow.put(in, i);
                lastOccurrence.put(i, in);
                max = Math.max(max, i - j + 1);
            }
            return max;
        }
    }
*/