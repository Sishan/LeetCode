/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false ;
        long absDiviend = Math.abs((long)dividend);  // store both diviend and divisor into long type
        long absDivisor = Math.abs((long)divisor);
        long res = 0;
        while(absDiviend >= absDivisor){
            long tmp = absDivisor, count = 1;
            while(tmp <= absDiviend){
                tmp <<= 1;
                count <<= 1;
            }
            res += count >> 1;
            absDiviend -= tmp >> 1;
        }
        return isNeg ? (int) ~res + 1 : res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }
}

Reference:
https://discuss.leetcode.com/topic/45980/very-detailed-step-by-step-explanation-java-solution