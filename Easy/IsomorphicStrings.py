"""
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
"""

class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        mapping = {}
        for index in xrange(len(s)):
            if not s[index] in mapping:
                # New mapping is found.
                mapping[s[index]] = t[index]
            elif mapping[s[index]] != t[index]:
                # No 2+ characters may map to the same character.
                return False
        # Make sure that no 2+ characters may map to the same character.
        if len(set(mapping.keys())) != len(set(mapping.values())):
            return False
        return True
