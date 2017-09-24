/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {

            // Remove element index that out of range k
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }

            // Remove indices of elements that are smaller than nums[i]
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                res[index++] = nums[dq.peek()];
            }
        }
        return res;
    }
}

/*
Reference:
https://discuss.leetcode.com/topic/19055/java-o-n-solution-using-deque-with-explanation
*/
