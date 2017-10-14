/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int zeroIdx = 0, twoIdx = nums.length - 1;
        for (int i = 0; i < nums.length; i++){
            // for all 2s, swap to the right
            while(nums[i] == 2 && i < twoIdx){
                nums[i] = nums[twoIdx];
                nums[twoIdx] = 2;
                twoIdx--;
            }
            // for all 0s, swap to the left
            while(nums[i] == 0 && i > zeroIdx){
                nums[i] = nums[zeroIdx];
                nums[zeroIdx] = 0;
                zeroIdx++;
            }
        }
    }
}

/*
Basic idea is to swap all 2s to the right side and 0s to the left side. Be careful we need to swap all 2s first, in case like [1,2,0]
*/