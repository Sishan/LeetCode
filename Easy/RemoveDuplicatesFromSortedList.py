"""
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if (head == None or head.next == None):
        	return head
        node  =  head
        while (node.next != None):
        	if (node.val == node.next.val):
        		node.next = node.next.next
        	else:
        		node = node.next
        return head
        
"""
Reference:
http://blog.csdn.net/linhuanmars/article/details/24354291
https://leetcodenotes.wordpress.com/2013/11/03/leetcode-remove-duplicates-from-sorted-array-1-2-%E4%BB%8E%E6%95%B0%E7%BB%84%E9%87%8Cinplace%E5%88%A0%E9%99%A4%E9%87%8D%E5%A4%8D/
"""