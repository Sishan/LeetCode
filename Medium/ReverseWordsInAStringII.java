/*
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
*/

class Solution {
    public void reverseWords(char[] str) {
        // reverse the whole string
        swap(str, 0, str.length - 1);
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            // reverse each word, left the last one
            if (str[i] == ' ') {
                swap(str, start, i - 1);
                start = i + 1;
            }
        }
        // reverse the last word
        swap(str, start, str.length - 1);
    }

    public void swap(char[] str, int left, int right) {
        while (left < right) {
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
    }
}