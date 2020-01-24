###
Given a non-negative integer N, find the largest number that is less than or equal to N 
with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent 
digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
Note: N is an integer in the range [0, 10^9].
###

class Solution(object):
    def monotoneIncreasingDigits(self, N):
        """
        :type N: int
        :rtype: int
        """
        s = list(str(N))
        monotoneIncreasingToTheLeftOf = len(s) - 1
        
        for x in range(len(s) - 1, 0, -1):
            if (s[x] < s[x - 1]):
                monotoneIncreasingToTheLeftOf = x - 1
                s[x - 1] = str(int(s[x - 1]) - 1)
                
        fillPosition = monotoneIncreasingToTheLeftOf + 1
        s[fillPosition:] = '9' * (len(s) - fillPosition)
        
        return int("".join(s))

###
Complexity Analysis

Time and Space Complexity: O(D), D is the number of digits in N

Logical Thinking
It is inductive that the result is in the form of:
initially monotone increasing digits (rightmost one among them should decrease 1) and set all right digits to '9'.
e.g. N = 12321, the result is 12299.
###