/*
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
*/

class Solution {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int mask = 0, max = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            HashSet<Integer> map = new HashSet<Integer>();
            for (Integer num : nums) {
                map.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (Integer prefix : map) {
                if (map.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}

/*
Basic idea is that a ^ b == c equals to a ^ c == b and b ^ c == a;
if the kth bit in the answer is 1, then we must have a1 and a2 in the hashset that a1 ^ 1 == a2
*/