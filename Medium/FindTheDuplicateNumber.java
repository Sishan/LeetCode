/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        int len = nums.length;

        while (fast < len && nums[fast] < len) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
        return -1;
    }
}

/*
When they meet, assume slow tag move s steps, fast tag move 2s steps, the circle length is c.
There must be:

2s = s + n*c

=> s = n*c....(1)

Then, assume the length from start point to entry point is x, and the length from the entry
point to the meet point is a.
There must be: s = x+a....(2)

So, from (1) and (2)

x+a = s = n*c

=> x+a = n*c

=> x+a = (n-1)*c+c

=> x = (n-1)*c+c-a

c-a means the length from the meetpoint to the entry point.

LHS means: the new tag from start point move x steps.

RHS means: the slow tag moves (n-1) cycles plus the length from the meetpoint to the entry point.
*/