"""
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
"""

class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if (needle == "" or haystack == needle):
            return 0
        if (len(needle) > len(haystack)):
            return -1
        for i in range(len(haystack) - len(needle) + 1):
            for j in range(len(needle)):
                if (haystack[i+j] != needle[j]):
                    break
                if (j == len(needle) - 1):
                    return i
        return -1
