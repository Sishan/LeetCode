/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStk = new Stack<Integer>();
        Stack<String> resStk = new Stack<String>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + s.charAt(idx) - '0';
                    idx++;
                }
                countStk.push(count);
            } else if (s.charAt(idx) == '[') {
                resStk.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder tmp = new StringBuilder(resStk.pop());
                int tmpCount = countStk.pop();
                for (int i = 0; i < tmpCount; i++) {
                    tmp.append(res);
                }
                res = tmp.toString();
                idx++;
            } else {
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;
    }
}