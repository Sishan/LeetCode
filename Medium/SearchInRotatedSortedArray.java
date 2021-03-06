/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target) return mid;
            
            if (nums[left] <= nums[mid]){
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
            
            else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}

/*
The key idea is that at least half of the array is sorted! Compare nums[mid] with nums[left] to determine if 
the left side is sorted, otherwise it is rotated.
Time complexity is O(logn)
*/