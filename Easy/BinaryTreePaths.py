# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {string[]}
    def binaryTreePaths(self, root):
        result = []
        if root == None:
            return result
        self.getPath(root, result, str(root.val))
        return result
    def getPath(self, root, result, path):
        if root.left == None and root.right == None:
            result.append(path)
        if root.left:
            self.getPath(root.left, result, path + "->" + str(root.left.val))
        if root.right:
            self.getPath(root.right, result, path + "->" + str(root.right.val))
