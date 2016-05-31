#Given a positive integer, return its corresponding column title as appear in an Excel sheet.
#For example:
#    1 -> A
#    2 -> B
#    3 -> C
#    ...
#    26 -> Z
#    27 -> AA
#    28 -> AB 

class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        if (n <= 0):
        	return ""
        result = ""
        while (n > 0):
            temp = n % 26
            n = n // 26
            if (temp == 0):
        	    result = "Z" + result
        	    n -= 1
            else:
        	    result = str(chr(temp+64)) + result
        return result
