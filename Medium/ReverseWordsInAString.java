/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] tmp = s.split("\\s+");					// "\\s" means one space, "\\s+" means one/more spaces, " " means one space, " +" means one/more spaces
        StringBuilder res = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--){
            //if (tmp[i].equals(" ")) continue;         //in fact, this will not happen
            res.append(tmp[i] + " ");
        }
        return res.toString().trim();
    }
}

/*
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        String input = s.trim().replaceAll(" +", " ");
        char[] sChar = input.toCharArray();
        reverse(sChar, 0, sChar.length - 1);
        int start = 0;
        for (int i = 0; i < sChar.length; i++){
            if (sChar[i] == ' '){
                reverse(sChar, start, i - 1);
                start = i + 1;
            }
        }
        reverse(sChar, start, sChar.length - 1);
        return new String(sChar);
    }
    
    public void reverse(char[] sChar, int left, int right){
        while (left < right){
            char tmp = sChar[left];
            sChar[left] = sChar[right];
            sChar[right] = tmp;
            left++;
            right--;            
        }
    }
}
*/