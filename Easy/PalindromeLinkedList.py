# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if (head == None or head.next == None):
        	return True;
        slow = head;
        fast = head;
        while (fast.next != None and fast.next.next != None):
        	fast = fast.next.next
        	slow = slow.next
        
        next = slow.next.next
        tail = slow.next

        while (next != None):   // reserve the list from the middle point 
        	temp = slow.next
        	slow.next = next
        	tail.next = next.next
        	next.next = temp
        	next = tail.next

        while (slow.next != None):
        	if (head.val != slow.next.val):
        		return False
        	head = head.next
        	slow = slow.next
        return True
        
