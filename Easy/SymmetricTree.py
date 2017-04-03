"""
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if (root == None):
          return True
        return self.isSymmetricHelper(root.left, root.right)
    def isSymmetricHelper(self, left, right):
        if (left == None and right == None):
          return True
        if (left == None or right == None):
          return False
        if (left.val != right.val):
          return False
        return self.isSymmetricHelper(left.left, right.right) and self.isSymmetricHelper(left.right, right.left)

###Version #2
class Solution(object):
    def isSymmetric(self, root):
        def sym_tree(L,R):
            if L and R: 
                return L.val == R.val and sym_tree(L.left, R.right) and sym_tree(L.right, R.left)
            else:
                return L == R
        return sym_tree(root, root)
