"""
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
"""

class Solution(object):
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        if (rowIndex < 0):
        	return []
        res = [1]
        for i in range(rowIndex):
        	for j in range(len(res)-2, -1, -1):
        		res[j+1] = res[j] + res[j+1]
                res.append(1)   #add "1" on the end
        return res
