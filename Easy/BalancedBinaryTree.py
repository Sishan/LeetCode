# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.maxDepth(root) != -1
        
    def maxDepth(self, root):
        if root == None:
            return 0;
        left = self.maxDepth(root.left)
        right  = self.maxDepth(root.right)
        if (left == -1 or right == -1 or abs(left - right) > 1):
            return -1
        else:
            return max(left, right) + 1
