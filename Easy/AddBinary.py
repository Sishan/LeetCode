"""
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
"""

class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        result = ""
        alen = len(a)
        blen = len(b)
        carry = False
        while (alen>=1 or blen>=1 or carry == True):
           counter = 0
           if (alen >= 1 and a[alen-1]== "1"):
             counter += 1
           if (blen >= 1 and b[blen-1] == "1"):
             counter += 1
           if (carry == True):
             counter += 1

           if (counter>1):
             carry = True
           else:
             carry = False

           if (counter % 2 == 1):
             result = "1" + result
           else:
             result = "0" + result
           alen -= 1
           blen -= 1

        return result
