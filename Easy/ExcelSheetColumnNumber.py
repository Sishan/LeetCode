###
Related to question Excel Sheet Column Title
Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
###

class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        if (s == None or len(s) == 0):
            return 0
        count = 0
        for i in range(len(s)):
            c = s[i]
            if (c > 'Z' or c < 'A'):
                return 0
            count = 26 * count + ord(c) - 64       # use ord() to convert char to int, and cha() to convernt int to char
        return count
