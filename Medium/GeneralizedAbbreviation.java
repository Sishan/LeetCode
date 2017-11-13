/*
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        backtrack(res, word, 0, 0, "");
        return res;
    }

    public void backtrack(List<String> res, String word, int pos, int count, String cur) {
        if (pos == word.length()) {
            if (count > 0) {
                cur += count;
            }
            res.add(cur);
        } else {
            backtrack(res, word, pos + 1, count + 1, cur);
            backtrack(res, word, pos + 1, 0, cur + (count > 0 ? count : "") + word.charAt(pos));
        }
    }
}