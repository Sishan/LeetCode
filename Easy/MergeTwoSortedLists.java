/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy  = new ListNode(0);
        ListNode last = dummy;
        while (l1 != null && l2 != null){
        	if (l1.val < l2.val){
        		last.next = l1;
        		l1 = l1.next;
        	}
        	else{
        		last.next = l2;
        		l2 = l2.next;
        	}
        	last = last.next;
        }

        if (l1 == null){
        	last.next = l2;                // if l1 does not end, directly add the rest of l1 to last node
        }
        else {
        	last.next = l1;
        }
        return dummy.next;
    }
}


/*
Because the two lists are already sorted, we can just compare their values node by node
For linked list, a dummy node is really helpful

Reference:
https://yusun2015.wordpress.com/2015/01/05/merge-two-sorted-lists/
http://blog.csdn.net/linhuanmars/article/details/19712593
https://leetcodenotes.wordpress.com/2013/08/01/merge-two-sorted-lists/
*/
