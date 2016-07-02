class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if (x < 0):
        	return False
        z = x
        y = 0
        while (z != 0):
        	y = 10*y + z%10
        	z = z/10
        return x == y