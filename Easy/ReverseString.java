/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

Subscribe to see which companies asked this question
*/

public class Solution {
    public String reverseString(String s) {
        if (s.length() == 0 || s == null) return "";
        char[] word = s.toCharArray();
        int left  = 0;
        int right  = s.length() - 1;
        while (left < right){
            char temp = word[left];
            word[left] = word[right];
            word[right] = temp;
            left++;
            right--;
        }
        return new String(word);
    }
}