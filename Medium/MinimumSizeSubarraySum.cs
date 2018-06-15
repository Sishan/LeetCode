/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
*/

public class Solution {
    public int MinSubArrayLen(int s, int[] nums) {
        return solve_in_N(s, nums);
    }
    
    private int solve_in_N(int s, int[] nums) 
    {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Int32.MaxValue;
        while (end < nums.Length) 
        {
            while (end < nums.Length && sum < s) 
            {
                sum += nums[end++];
            }
            if (sum < s) 
            {
                break;
            }
            while (start < end && sum >= s)
            {
                sum -= nums[start++];
            }
            minLen = Math.Min(minLen, end - start + 1);
        }
        return minLen == Int32.MaxValue ? 0 : minLen;
    }
}