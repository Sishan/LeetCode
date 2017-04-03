/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/



// Faster solution using two pointer
public class Solution {
  public boolean isPalindrome(String s) {
      if(s == null || s.length() <= 1) return true;
      int left = 0;
      int right = s.length() - 1;
      s = s.toLowerCase();
      while(left < right){
           if(!Character.isLetterOrDigit(s.charAt(left)))left++;
           else if(!Character.isLetterOrDigit(s.charAt(right)))right--;
           else if(s.charAt(left) != s.charAt(right))return false;
           else{
              left++;
              right--;
        }
      }
       return true;
  }
} 

/*
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        String scopy = sb.reverse().toString();
        return scopy.equals(s);
    }
}
*/