/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it
will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money 
you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        int n  = nums.length;
        if (n < 2){
        	return n == 0 ? 0 : nums[0];
        }

        int[] cache = new int[n];
        cache[0] = nums[0];
        cache[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < n; i ++){
        	cache[i] = Math.max(cache[i-1], cache[i-2]+nums[i]);
        }
        return cache[n-1];
    }
}
