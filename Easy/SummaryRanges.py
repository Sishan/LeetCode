"""
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
"""

class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        res = []
        start = 0
        end = start
        if (nums == None or len(nums) == 0):
        	return res
        for i in xrange(len(nums)):
        	if ((i < len(nums) - 1) and (nums[i] + 1 == nums[i + 1])):
        		end += 1
        	elif (start == end):
        		res.append(str(nums[start]))
        		end += 1
        		start = end
        	else:
        		res.append(str(nums[start])+"->"+str(nums[end]))
        		end += 1
        		start = end
        return res
