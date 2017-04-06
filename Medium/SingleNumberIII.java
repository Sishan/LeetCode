/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums){       // Get the XOR of the two numbers we need to find
            diff ^= num;
        }
        diff &= -diff;              // Get the last set bit
        int[] res = {0, 0};         
        for (int num : nums){       // Divide nums into two groups
            if ((num & diff) == 0) res[0] ^= num;   // first subgroup with non-set bit
            else res[1] ^= num;                     // second subgroup with set bit
        }
        return res;
    }
}

/*
Reference:
https://discuss.leetcode.com/topic/21605/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations
*/