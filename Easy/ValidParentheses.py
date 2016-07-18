"""
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
"""

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if (s == None or len(s) == 0):
        	return True
        record = []
        for i in xrange(len(s)):
        	cur = s[i]
        	if cur == '(' or cur == '{' or cur == '[':
        		record.append(cur)
        	if cur == ')':
        		if (not record or record.pop() != '('):
        			return False
        	if cur == '}':
        		if (not record or record.pop() != '{'):
        			return False
        	if cur == ']':
        		if (not record or record.pop()!= '['):
        			return False
        if not record:
        	return True
        return False