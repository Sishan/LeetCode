/*
Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
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
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode i = dummy;
        ListNode j = dummy;
        dummy.next = head;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }

        if (j.val != 9) {
            j.val++;
        } else {
            i.val += 1;
            while (i.next != null) {
                i.next.val = 0;
                i = i.next;
            }
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }
}

// Recursive solution
/*
public ListNode plusOne(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    helper(dummy);
    return dummy.val == 0 ? head : dummy;
}

private int helper(ListNode node){
    if(node == null) return 1;
    node.val += helper(node.next);
    if(node.val <= 9) return 0;
    node.val %= 10;
    return 1;
}
*/