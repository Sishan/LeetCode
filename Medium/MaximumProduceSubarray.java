/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curMax = nums[0], curMin = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] < 0) {          // swap(curMax, curMin) inside the loop
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            curMax = Math.max(nums[i], curMax * nums[i]);
            curMin = Math.min(nums[i], curMin * nums[i]);
            res = Math.max(res, curMax);
        }
        return res;
    }
}

/*
Reference:
https://discuss.leetcode.com/topic/4417/possibly-simplest-solution-with-o-n-time-complexity
*/