/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] sChar = s.toCharArray();
        int start = 0;
        for (int j = 0; j < sChar.length; j++) {
            if (sChar[j] == ' ') {
                reverse(sChar, start, j - 1);
                start = j + 1;
            }
        }
        reverse(sChar, start, sChar.length - 1);
        return new String(sChar);
    }

    public void reverse(char[] sChar, int left, int right) {
        while (left < right) {
            char tmp = sChar[left];
            sChar[left] = sChar[right];
            sChar[right] = tmp;
            left++;
            right--;
        }

    }
}