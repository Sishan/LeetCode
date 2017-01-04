/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
    	if (n <= 0) return "";
    	String result = "1";
    	for (int i = 2; i <= n; i++){
    		StringBuilder sb = new StringBuilder();
    		int count  = 1;
    		for (int j = 1; j <= result.length(); j++){
    			if ((j < result.length()) && result.charAt(j) == result.charAt(j-1)) count++;
    			else{
    				sb.append(count);
    				sb.append(result.charAt(j-1));
    				count = 1；
    			}
    		}
    		result = sb.toString();
    	}
    	return result;
    }
}


/*
Reference:
https://leetcode.com/discuss/37219/possible-solutions
https://leetcode.com/discuss/37355/java-solution-with-sorting-o-nlog-n-time-o-1-space
https://leetcode.com/discuss/37190/java-o-n-ac-solutions-with-hashset-and-bitset
*/
