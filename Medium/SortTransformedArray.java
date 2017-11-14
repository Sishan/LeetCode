/*
Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
*/

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] sorted = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int idx = a >= 0 ? nums.length - 1 : 0;
        while (i <= j){
            if (a >= 0){
                sorted[idx--] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
            } else {
                sorted[idx++] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[j--], a, b, c) : quad(nums[i++], a, b, c);
            }
        }
        return sorted;
    }
    
    public int quad(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }
}