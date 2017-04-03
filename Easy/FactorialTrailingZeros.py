#Given an integer n, return the number of trailing zeroes in n!.
#Note: Your solution should be in logarithmic time complexity.

class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        sum = 0
        i = n/5
        while (i>0):
            sum += i
            i = i/5
        return sum
