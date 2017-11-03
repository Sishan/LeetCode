/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int start = 0, end = nums.length - 1;
        while(start < end){
            int mid = (start + end) >> 1; // mid always smaller than end
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[start] <= nums[mid] && nums[end] < nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return nums[start];
    }
}

/*
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            } else if (nums[mid] > nums[right]){
                 left = mid + 1;
             }
        }
        return nums[left];
    }
}
*/
