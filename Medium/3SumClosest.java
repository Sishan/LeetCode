/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3)
			return 0;
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
				closest = Math.abs(sum - target) < Math.abs(closest - target) ? sum : closest;
			}
		}
		return closest;
	}
}

/*
这道题跟3Sum很类似，区别就是要维护一个最小的diff，求出和目标最近的三个和。
brute force时间复杂度为O(n^3)，优化的解法是使用排序之后夹逼的方法，总的时间复杂度为O(n^2+nlogn)=(n^2),空间复杂度是O(n),

Analysis:
1. for any i we can choose num[i] as the first element.
2. use another two pointer mid and right to form a window;
3. adjust the mid an right to reduce the difference between sum and target.

Reference:
http://www.ninechapter.com/solutions/3sum-closest/
http://blog.csdn.net/linhuanmars/article/details/19712011
https://yusun2015.wordpress.com/2015/01/12/3sum-closest/
*/