"""
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if (root == None):
        	return 0
        return self.getMin(root)

    def getMin(self,root):
        """
        helper function for recursion the tree
        """
    	if (root == None):
    		return sys.maxint  #prevent to count not-end leaves
    	if (root.left == None and root.right == None):
    		return 1
    	return min(self.getMin(root.left), self.getMin(root.right)) + 1
