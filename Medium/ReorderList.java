/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head, pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = head;
        pre.next = null;
        ListNode l2 = reverseList(slow);
        merge(l1, l2);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void merge(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            ListNode next1 = h1.next;
            ListNode next2 = h2.next;

            h1.next = h2;
            if (next1 == null) {
                break;
            }
            h2.next = next1;

            h1 = next1;
            h2 = next2;
        }
    }
}