"""
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
"""

class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        if (nums == None):
        	return 0
        count = 0
        for x in xrange(len(nums)):
        	if (nums[i] != val):
        		nums[count] = nums[i]
        		count += 1
        return count
        