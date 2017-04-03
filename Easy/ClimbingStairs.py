#You are climbing a stair case. It takes n steps to reach to the top.
#Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1 or n == 2:
            return n
        stepone = 1
        steptwo = 2
        for i in range (n-2):
            stepthree = stepone + steptwo
            stepone = steptwo
            steptwo = stepthree
        return stepthree
