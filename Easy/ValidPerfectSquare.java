/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
*/

public boolean isPerfectSquare(int num) {
        long low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

// Version 2 with Newtown Method
public class Solution {
    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num){
            x = (x + num/x) >> 1;
        }
        return x * x == num;
    }
}