/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int size = 1; // since we are already at head node
        ListNode fast = head, slow = head;

        while (fast.next != null) {
            size++;
            fast = fast.next;
        }

        for (int i = size - k % size; i > 1; i--){ // i>1 because we need to put slow.next at the start.
            slow = slow.next;
        }
        
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}

/*
Reference:
https://discuss.leetcode.com/topic/2861/share-my-java-solution-with-explanation
*/
