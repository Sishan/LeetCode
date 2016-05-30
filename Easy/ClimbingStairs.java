/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class Solution {
    public int climbStairs(int n) {
        int stepOne = 1;
        int stepTwo = 2;
        if (n == 1) return 1;
        if (n == 2) return 2;

        for (int i = 0; i <= n; i ++){
        	int stepThree = stepOne + stepTwo;
        	stepOne = stepTwo;
        	stepTwo = stepThree;
        }
        return stepTwo;
    }
}
