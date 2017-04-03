/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast){
                ListNode slowRedo = head;
                while(slow != slowRedo){
                    slow = slow.next;
                    slowRedo = slowRedo.next;
                }
                return slow;
            }
        }
        return null;
    }
}

/*
Advanced version of Linked List Cycle.
Key idea:
Let the distance from the first node to the the node where cycle begins be A, and let say the slow pointer 
travels travels A+B. The fast pointer must travel 2A+2B to catch up. The cycle size is N. Full cycle is 
also how much more fast pointer has traveled than slow pointer at meeting point.

A+B+N = 2A+2B
N=A+B

From our calculation slow pointer traveled exactly full cycle when it meets fast pointer, and since originally 
it travled A before starting on a cycle, it must travel A to reach the point where cycle begins! We can start 
another slow pointer at head node, and move both pointers until they meet at the beginning of a cycle.
Reference:
https://discuss.leetcode.com/topic/19367/java-o-1-space-solution-with-detailed-explanation
*/