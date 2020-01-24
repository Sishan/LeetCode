/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);  
        ListNode p = l1, q = l2, current = dummy;     
        int carry = 0;
        
        while (p != null || q != null)
        {
            int x = (p != null)? p.val : 0;
            int y = (q != null)? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            if (p != null) 
            {
                p = p.next;
            }
            
            if (q != null)
            {
                q = q.next;
            }
        }
        
        if (carry != 0)
        {
            current.next = new ListNode(1);
        }
        
        return dummy.next;
    }
}

/*
REMEMBER mod and divide:
digit = (l1.val+l2.val+carry)%10; 		// get the digit
carry = (l1.val+l2.val+carry)/10;		// get the carry

Keep track of the carry using a variable and simulate digits-by-digits sum from the head of list, 
which contains the least-significant digit.
Take extra caution of the following cases:
- When one list is longer than the other.
- The sum could have an extra carry of one at the end, which is easy to forget. 
- (e.g., (9->9) + (1) = (0->0->1))

Complexity Analysis:
Time = Space = O(max(m,n)). 
m and n represents the length of l1 and l2 respectively
*/