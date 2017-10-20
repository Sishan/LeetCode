/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/

class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tmp = new int[nums.length + 2];
        int n = 1;
        for (int i : nums) {
            if (i > 0) {
                tmp[n++] = i;
            }
        }
        tmp[0] = tmp[n++] = 1;
        int[][] dp = new int[nums.length + 2][nums.length + 2];

        return burst(tmp, dp, 0, nums.length + 1);
    }

    public int burst(int[] tmp, int[][] dp, int left, int right) {
        if (left == right - 1) {
            return 0;
        }
        if (dp[left][right] > 0) {
            return dp[left][right];
        }
        int res = 0;
        for (int i = left + 1; i < right; i++) {
            res = Math.max(tmp[left] * tmp[i] * tmp[right] + burst(tmp, dp, left, i) + burst(tmp, dp, i, right), res);
        }
        dp[left][right] = res;
        return res;
    }
}