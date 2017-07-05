/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.length==0 || strs==null) return "";     // if empty, return "" which is empty but NOT null !

        boolean isSame = true;
        int len = 0;		// the pointer
        while(isSame){
            for(int i=0; i<strs.length; i++){
                if(strs[i].length()<=len || strs[i].charAt(len)!=strs[0].charAt(len)){		// for the case not the same: str[i].length() <= len or not the same
                    isSame = false;
                    break;			// remember to jump out of this for loop if not the same
                }
            }
        	if(isSame){
            	sb.append(strs[0].charAt(len));
            	len++;
        	}
        }
        return sb.toString(); 
    }
}

/*
Time complexity is O(m*n) - m is max length of string, n is the number of strings
Space complexity is O(m)

Another solution is substring, run time is O(1):
result.substring(0,len)

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int pos = 0;
        boolean isVaild = true;
        while(isVaild){
            for (int i = 0; i < strs.length; i++){
                if (strs[i].length() <= pos || strs[i].charAt(pos) != strs[0].charAt(pos)){
                    isVaild = false;
                    break;
                }
            }
            if (isVaild) pos++;
        }
        return pos > strs[0].length() ? strs[0] : strs[0].substring(0, pos);
    }
}

See this solution at:
https://yusun2015.wordpress.com/2015/01/12/longest-common-prefix
*/
