/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/


public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        int left = 0, right = nums.length - 1;
        
        // search for the left part, biased to the left
        while (left < right){
            int mid = left + (right - left) / 2;  // left <= mid < right
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        if (nums[left] != target) return res;
        else res[0] = left;
        
        // search for the right part
        right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2 + 1; // mid biased to the right
            if (target < nums[mid]) right = mid - 1;
            else left = mid;
        }
        res[1] = right;
        return res;
    }
}


/*
Reference:
https://discuss.leetcode.com/topic/5891/clean-iterative-solution-with-two-binary-searches-with-explanation
https://leetcode.com/submissions/detail/109371923/