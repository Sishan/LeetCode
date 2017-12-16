/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
*/

class Solution {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[] { 0, i, i });
            }
            map.get(nums[i])[0]++;
            map.get(nums[i])[2] = i;
        }

        int maxFre = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;
        for (int[] pair : map.values()) {
            if (pair[0] > maxFre) {
                maxFre = pair[0];
                minLen = pair[2] - pair[1] + 1;
            } else if (pair[0] == maxFre) {
                minLen = Math.min(minLen, pair[2] - pair[1] + 1);
            }
        }
        return minLen;
    }
}