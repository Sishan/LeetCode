/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/

class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] bucketMax = new int[nums.length - 1];
        int[] bucketMin = new int[nums.length - 1];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        for (int cur : nums) {
            if (cur == max || cur == min) {
                continue;
            }
            int idx = (cur - min) / gap;
            bucketMin[idx] = Math.min(bucketMin[idx], cur);
            bucketMax[idx] = Math.max(bucketMax[idx], cur);
        }

        int maxGap = Integer.MIN_VALUE;
        int pre = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE && bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketMin[i] - pre);
            pre = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - pre);
        return maxGap;
    }
}