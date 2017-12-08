/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.length() == 0 || s.length() < words.length * words[0].length()) {
            return res;
        }

        int N = s.length(), M = words.length, K = words[0].length();
        Map<String, Integer> count = new HashMap<String, Integer>();
        Map<String, Integer> curCount = new HashMap<String, Integer>();

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        String str = null, tmp = null;
        for (int i = 0; i < K; i++) { // scan (i, i + k, i + 2k, ...) and (i + 1, i + 1 + k, i + 1 + 2k, ...) and so on
            int counts = 0;
            for (int l = i, r = i; r + K <= N; r += K) { // sliding window 
                str = s.substring(r, r + K); // check K more characters each time to the right side
                if (count.containsKey(str)) {
                    curCount.put(str, curCount.getOrDefault(str, 0) + 1);
                    if (curCount.get(str) <= count.get(str)) {
                        counts++;
                    }
                    while (curCount.get(str) > count.get(str)) {
                        tmp = s.substring(l, l + K);
                        curCount.put(tmp, curCount.get(tmp) - 1);
                        l += K;
                        if (curCount.get(tmp) < count.get(tmp)) {
                            counts--;
                        }
                    }
                    if (counts == M) {
                        res.add(l);
                        tmp = s.substring(l, l + K);
                        curCount.put(tmp, curCount.get(tmp) - 1);
                        l += K;
                        counts--;
                    }
                } else {
                    curCount.clear();
                    counts = 0;
                    l = r + K;
                }
            }
            curCount.clear();
        }
        return res;
    }
}