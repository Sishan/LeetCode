/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        while(head != null){
            ListNode pre = dummy;
            while(pre.next != null &&  pre.next.val <= head.val) pre = pre.next;
            ListNode tmp = head.next;
            head.next = pre.next;
            pre.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}

/*
Using a dummy starter here, and then we will delink and insert each node from the original link to the new 
list starts with dummy. Also for this reason, we do not assign dummy.next = head.
*/