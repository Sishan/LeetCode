# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root == None:
        	return []
        queue = [root]
        result = []
        while queue:
        	level = []
        	size = len(queue)
        	for i in range(size):
        		head = queue.pop(0)
        		level.append(head.val)
        		if head.left:
        			queue.append(head.left)
        		if head.right:
        			queue.append(head.right)
        	result.append(level)
        return result
