/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public int romanToInt(String s) {
    	int len = s.length();
    	if (s == null || len == 0) return 0;
        Map<Character, Integer> value = new HashMap<Character, Integer>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);


        int res = value.get(s.charAt(len-1));
        int pre = res;
        for (int i = len - 2; i >=0; i --){
            int cur = value.get(s.charAt(i));
            // note the logic here: only compare cur with pre
            if (cur < pre) res -= cur;
            else res += cur;
            pre = cur;
        }
        return res;

    }
}

/*
Roman numeral: I=1, V=5, X=10, L=50, C=100, D=500, M=1000.
Roman to Integer: If the smaller number is ahead of the bigger one, need to use the bigger one minus the smaller one, otherwise sum the two numbers up.

Similar:
Integer to Roman

Reference:
https://leetcodenotes.wordpress.com/2013/08/14/leetcode-roman-to-integer-%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97%E8%BD%AC%E6%8D%A2%E6%88%90%E6%95%B4%E6%95%B0/
https://yusun2015.wordpress.com/2015/01/05/roman-to-integer-integer-to-roman/
https://oj.leetcode.com/discuss/24297/my-easy-understanded-python-solution-in-160-ms
*/