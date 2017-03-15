/*
Given an integer, write a function to determine if it is a power of three.
*/

public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0  && (Math.pow(3, 19))%n == 0;   // use the fact that 3^(log3(MAX_VALIE)) = 3^19
    }
}

