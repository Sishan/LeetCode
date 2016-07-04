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
        	cur.append(1)
        	res.append(cur)
        	pre = cur
        return res
