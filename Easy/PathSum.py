"""
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if (root == None):
        	return False
        if (root.left == None and root.right == None):
        	return sum == root.val
        return (self.hasPathSum(root.left, sum - root.val) or self.hasPathSum(root.right, sum - root.val))
        
"""
Reference:
https://leetcodenotes.wordpress.com/2013/08/04/leetcode-pathsum-%E6%89%BE%E4%BB%8Eroot%E5%88%B0leaft%E7%9A%84%E5%8A%A0%E5%92%8Cx%E7%9A%84%E8%B7%AF%E5%BE%84%E6%98%AF%E5%90%A6%E5%AD%98%E5%9C%A8/
https://leetcodenotes.wordpress.com/2013/08/04/leetcode-pathsum-%E6%89%BE%E4%BB%8Eroot%E5%88%B0leaft%E7%9A%84%E5%8A%A0%E5%92%8Cx%E7%9A%84%E8%B7%AF%E5%BE%84%E6%98%AF%E5%90%A6%E5%AD%98%E5%9C%A8iteratively/
http://www.ninechapter.com/solutions/path-sum/
http://blog.csdn.net/linhuanmars/article/details/23654413
"""
