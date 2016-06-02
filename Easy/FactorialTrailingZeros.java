/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

public class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        int i = n/5;

        while (i>0){
        	sum = sum + i;
        	i = i/5;
        }
        return sum;
    }
}

/*
Need to find how many 5s there are as factor of n!
10 is the product of 2 and 5. In n!, we need to know how many 2 and 5, and the number of zeros is the minimum of the number of 2 and the number of 5.
Since multiple of 2 is more than multiple of 5, the number of zeros is dominant by the number of 5. 
Sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors. 
*/
