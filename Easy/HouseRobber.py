"""
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only 
constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically 
contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can 
rob tonight without alerting the police.
"""

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        n = len(nums)
        if (n == 0):
            return 0
        if (n == 1):
            return nums[0]
        result = [nums[0], max(nums[0], nums[1])]
        for i in range(2,n):
            result.append(max(result[i-1], result[i-2]+nums[i]))
        return result[n-1]
