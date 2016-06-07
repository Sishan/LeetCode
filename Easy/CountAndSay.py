"""
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
Note: The sequence of integers will be represented as a string.
"""


class Solution(object):
    def countAndSay(self,n):
        """
        :type n: int
        :rtype: str
        """
        
        if (n <= 0):
            return ""
        result = "1"

        for i in range(n-1):
            count = 1
            temp = ""
            for j in range(len(result)):
                if ((j<len(result)-1) and result[j] == result[j+1]):
                    count += 1
                else:
                    temp += str(count)
                    temp += result[j]
                    count = 1
            result = temp
        return result
