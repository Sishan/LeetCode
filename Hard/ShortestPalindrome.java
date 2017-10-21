/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/

class Solution {
    public String shortestPalindrome(String s) {
        String tmp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = buildTable(tmp);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }
    

    // Build KMP table 
    public int[] buildTable(String tmp){
        int[] res = new int[tmp.length()];
        
        int index = 0;
        for (int i = 1; i < tmp.length(); i++){
            if (tmp.charAt(index) == tmp.charAt(i)){
                res[i] = res[i - 1] + 1;
                index++;
            }
            else {
                index = res[i - 1];
                while (index > 0 && tmp.charAt(index) != tmp.charAt(i)){
                    index = res[index - 1];
                }
                if (tmp.charAt(index) == tmp.charAt(i)){
                    index++;
                }
                res[i] = index;
            }
        }
        return res;
    }
}

/*
Reference:
https://discuss.leetcode.com/topic/27261/clean-kmp-solution-with-super-detailed-explanation
*/