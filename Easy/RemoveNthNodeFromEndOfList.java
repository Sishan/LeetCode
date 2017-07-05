/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        int count = 0;
        while (fast != null){
        	fast = fast.next;
        	count ++;		
        	if (count > n){
        		slow = slow.next;
        	}
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

/*
Ask the interviewer: is it singly linked list or doubly linked list? is n always valid?

At first we don't know the length of the linked list, so we have to travese all the list to get the length using fast node
we use fast node n steps beyond the slow node to indicate the nth node

Use slow and fast pointers and keep their distance with n. When the  fast get to the end, the slow is at the nth note from the end.
So delete the node at which the slow pointer points. Dummy head is useful here, as you can use it to get the previous node of the slow one easily.

Reference:
https://yusun2015.wordpress.com/2015/01/10/remove-nth-node-from-end-of-list/
https://github.com/leetcoders/LeetCode-Java/blob/master/RemoveNthNodeFromEndofList.java
http://blog.csdn.net/linhuanmars/article/details/19778441
http://www.ninechapter.com/solutions/remove-nth-node-from-end-of-list/
*/