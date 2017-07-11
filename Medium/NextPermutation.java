/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = len - 1;
        if (nums == null || len < 2) return;

        // Start from the last element, traverse backward to find the first one 
        // with index i that satisfy num[i-1] < num[i]
        while (index > 0){
            if (nums[index - 1] < nums[index]){
                break;
            }
            index --;
        }

        // If such arrangement is not possible, rearrange it as the 
        // lowest possible order (ie, sorted in ascending order)
        if (index == 0) {
            reverse(nums, 0, len -1);
            return;
        }

        // Increase the number at index i-1; swap it with the smallest 
        // number between num[i,n-1] that is larger than num[i-1].
        else{
            int val = nums[index-1];
            int j = len - 1;
            while (j >= index){
                if (nums[j] > val){
                    break;
                }
                j--;
            }
            swap(nums, j, index - 1);
            // Reversely sort the num[i,n-1]
            reverse(nums, index, len - 1);
            return;
        }
    }
    
    public void swap(int[] nums, int left, int right){
        int tmp = 0;
        tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    
    public void reverse(int[] nums, int left, int right){
        if (left > right) return;
        for (int i = left; i <= (right + left) / 2; i++){
            swap(nums, i, left + right - i);
        }
    }
}

/*
Reference:
https://leetcode.com/problems/next-permutation/#/solutions
*/