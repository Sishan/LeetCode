"""
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets
"""
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if (s == None or t == None or len(s) != len(t)):
        	return False
        count = {}
        for i in s:
        	count[i] = count.get(i,0) + 1
        for i in t:
        	count[i] = count.get(i,0) - 1
        	if count[i] < 0:
        		return False
        return True
