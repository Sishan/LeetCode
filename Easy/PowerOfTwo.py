"""
Given an integer, write a function to determine if it is a power of two.
"""

class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if (n <= 0):
        	return False
        return (n & (n-1)) == 0

"""
(x-1) & x == 0 → x is a power of two
http://algorithm.yuanbin.me/math_and_bit_manipulation/o1_check_power_of_2.html
"""