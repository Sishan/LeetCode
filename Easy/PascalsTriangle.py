"""
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
"""

class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        if (numRows <= 0):
        	return []
        pre = [1]
        res = [pre]
        for x in range(numRows-1):
        	cur = [1]
        	for y in range(len(pre)-1):
        		cur.append(pre[y] + pre[y + 1])
        	cur.append(1)  #add "1" at the end
        	res.append(cur)
        	pre = cur
        return res
