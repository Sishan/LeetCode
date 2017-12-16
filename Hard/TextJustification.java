/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
*/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if (words.length == 0 || maxWidth == 0) {
            res.add("");
            return res;
        }

        for (int i = 0, w; i < words.length; i = w) {
            int len = -1; // skip the space for the last word, starts with -1
            for (w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++) {
                len += words[w].length() + 1;
            }

            int evenSpace = 1;
            int extraSpace = 0;
            int gaps = w - i - 1; // w now is pointint to next index

            if (w != i + 1 && w != words.length) {
                evenSpace = ((maxWidth - len) / gaps) + 1;//additional 1 for the default one space between words
                extraSpace = (maxWidth - len) % gaps;
            }

            StringBuilder sb = new StringBuilder(words[i]);
            for (int j = i + 1; j < w; j++) {
                for (int s = 0; s < evenSpace; s++) {
                    sb.append(' ');
                }
                if (extraSpace > 0) {
                    sb.append(' ');
                    extraSpace--;
                }
                sb.append(words[j]);
            }

            //Handle the above two cases we skipped, where there is only one word on line
            //or we reached end of word array. Last line should remain left aligned.
            int remaining = maxWidth - sb.length();
            while (remaining > 0) {
                sb.append(' ');
                remaining--;
            }
            res.add(sb.toString());
        }
        return res;
    }
}