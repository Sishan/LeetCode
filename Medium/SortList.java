/*
Sort a linked list in O(n log n) time using constant space complexity.
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
    ListNode dummyRes = new ListNode(0);
    public class MergeResult {
        ListNode head;
        ListNode tail;
        MergeResult(ListNode h, ListNode t) { head = h; tail = t;}
    } 
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        int length = length(head); // get the length of list
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        MergeResult mr = new MergeResult(null, null);
        
        for(int step = 1; step < length; step <<= 1) {
            ListNode left = dummy.next;
            ListNode prev = dummy;
            while(left != null) {
                ListNode right = split(left, step);
                if(right == null) {
                    prev.next = left;
                    break;
                }
                ListNode next = split(right, step);
                merge(left, right, mr);
                prev.next = mr.head;
                prev = mr.tail;
                left = next;
            }
        }
        
        return dummy.next;
    }

   // obtain the length of list
    public int length(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
    
    // get the right side node for each merge sort step
    public ListNode split(ListNode head, int step) {
        while(head != null && step != 1) {
            head = head.next;
            step--;
        }
        if(head == null) return null;
        ListNode res = head.next;
        head.next = null;
        return res;
    }
    
    // merge two lists, start with dymmyRes (ListNode(0)) and followed by smallest element 
    public void merge(ListNode head1, ListNode head2, MergeResult mr) {
        if(head2 == null) {
            mr.head = head1;
            mr.tail = null;
        }
        ListNode res = dummyRes;
        ListNode tail = res;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        
        while(head1 != null) {
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
        }
        
        while(head2 != null) {
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }
        
        mr.head = res.next;
        mr.tail = tail;
    }
}

//Nice and clear solution using recursion merge sort, but indeed using O(nlongn) space
public class Solution {
  
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
        
    // step 1. cut the list to two halves
    ListNode prev = null, slow = head, fast = head;
    
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    
    prev.next = null;
    
    // step 2. sort each half
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);
    
    // step 3. merge l1 and l2
    return merge(l1, l2);
  }
  
  ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p = l;
    
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    
    if (l1 != null)
      p.next = l1;
    
    if (l2 != null)
      p.next = l2;
    
    return l.next;
  }

}