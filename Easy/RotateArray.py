"""
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Hint:
Could you do it in-place with O(1) extra space?
"""

public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k = k % nums.length;								// in case that k>nums.length
        reverse(nums, 0, nums.length - 1 - k);				// rotate three times
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    private void reverse(int[] nums, int left, int right){
    	while (left < right){
    		int temp = nums[left];
    		nums[left] = nums[right];
    		nums[right] = temp;
    		left ++;
    		right --;
    	}
    }
}



