/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) return true;
        if (magazine.length() == 0 || ransomNote.length() > magazine.length()) return false;
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++){
            int val = magazine.charAt(i)-'a';
            map[val]++;
        }
        for (int j = 0; j < ransomNote.length(); j++){
            int val = ransomNote.charAt(j)-'a';
            if (map[val] > 0) map[val]--;
            else return false;
        }
        return true;
    }
}