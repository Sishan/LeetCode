/*
A string such as "word" contains the following abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.

Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

Note:
In the case of multiple answers as shown in the second example below, you may return any one of them.
Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.
Examples:
"apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

"apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").
*/

class Solution {
    int n, cand, bn, minlen, minab;
    List<Integer> dict = new ArrayList<>();

    private int abbrLen(int mask) {
        int count = n;
        for (int b = 3; b < bn; b <<= 1) {
            if ((mask & b) == 0) {
                count--;
            }
        }
        return count;
    }

    private void dfs(int bit, int mask) {
        int len = abbrLen(mask);
        if (len > minlen) {
            return;
        }
        boolean match = true;
        for (Integer d : dict) {
            if ((mask & d) == 0) {
                match = false;
                break;
            }
        }

        if (match) {
            minlen = len;
            minab = mask;
        } else {
            for (int b = bit; b < bn; b <<= 1) {
                if ((cand & b) != 0) {
                    dfs(b << 1, mask + b);
                }
            }
        }
    }

    public String minAbbreviation(String target, String[] dictionary) {
        n = target.length();
        bn = 1 << n;
        cand = 0;
        minlen = Integer.MAX_VALUE;
        StringBuilder res = new StringBuilder();

        for (String s : dictionary) {
            int word = 0;
            if (s.length() != n) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (target.charAt(i) != s.charAt(i)) {
                    word |= 1 << i;
                }
            }
            dict.add(word);
            cand |= word;
        }

        dfs(1, 0);

        for (int i = 0; i < n;) {
            if ((minab & (1 << i)) != 0) {
                res.append(target.charAt(i++));
            } else {
                int j = i;
                while (i < n && ((minab & (1 << i)) == 0)) {
                    i++;
                }
                res.append(i - j);
            }
        }
        return res.toString();
    }
}