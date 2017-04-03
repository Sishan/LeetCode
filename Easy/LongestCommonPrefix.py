"""
Write a function to find the longest common prefix string amongst an array of strings.
"""

class Solution(object):
    def longestCommonPrefix(self, strs):
        prefix = '';
    # * is the unpacking operator, essential here
        for z in zip(*strs):
            bag = set(z);
            if len(bag) == 1:
                prefix += bag.pop();
            else:
                break;
        return prefix;
