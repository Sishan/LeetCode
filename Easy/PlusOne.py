"""
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
"""

class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        if len(digits) == 0 or digits == None:
        	return digits
        carry = 1
        for  i in range(len(digits)):
        	lastDigit = (digits[len(digits) - 1- i] + carry)%10
        	carry = (digits[len(digits) - 1 - i] + carry)//10
        	digits[len(digits) -1 -i] = lastDigit
        	if (carry == 0):
        		return digits
        res = [0]*(len(digits)+1)
        res[0] = 1
        return res