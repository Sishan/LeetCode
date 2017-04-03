"""
Reverse a singly linked list.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        newHead = null
        while (head != None):
        	next = head.next
        	head.next = newHead
        	newHead = head
        	head = next
        return newHead

#recursive soltuion
class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        return self.reverse(head, null)
    
    def reverse(self, head, newHead):
    	if (head == None):
    		return newHead
    	next = head.next
    	head.next = newHead
    	return self.reverse(next, head)