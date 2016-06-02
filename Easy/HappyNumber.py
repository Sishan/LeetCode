#Write an algorithm to determine if a number is "happy".
#A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
#Example: 19 is a happy number
#1^2 + 9^2 = 82
#8^2 + 2^2 = 68
#6^2 + 8^2 = 100
#1^2 + 0^2 + 0^2 = 1

class Solution(object):
    def isHappy(self, n):                                   #Floyd Cycle detection algorithm
        """
        :type n: int
        :rtype: bool
        """
        slow = self.digitSquareSum(n)        
        fast = self.digitSquareSum(self.digitSquareSum(n))

        while (slow != 1 and slow != fast):
        	slow = self.digitSquareSum(slow)
        	fast = self.digitSquareSum(self.digitSquareSum(fast))

        if (slow == 1):
        	return True
        else:
        	return False

    def digitSquareSum(self,n):
    	sum = 0
    	while (n > 0):
    		temp = n % 10
    		sum += temp * temp
    		n /= 10
    	return sum
