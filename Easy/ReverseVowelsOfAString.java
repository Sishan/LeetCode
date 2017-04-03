/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/

public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        char[] varray = s.toCharArray();
        int left  = 0;
        int right = s.length() -1;
        while (left < right){
            while (left < right && !vowels.contains(String.valueOf(s.charAt(left)))) left++;
            while (left < right && !vowels.contains(String.valueOf(s.charAt(right)))) right--;
            varray[left] = s.charAt(right);
            varray[right] = s.charAt(left);
            left ++;
            right --;
        }
        return new String(varray);
    }
}