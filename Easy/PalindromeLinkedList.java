/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution  {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) return true;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode next = slow.next.next;
		ListNode tail = slow.next;

		while(next != null){
			ListNode temp = slow.next;
			slow.next = next;
			tail.next = next.next;
			next.next = temp;
			next = tail.next;
		}

		while (slow.next != null){
			if (head.val != slow.next.val) return false;
			head = head.next;
			slow = slow.next;
		}
		return true;
	}
}


/*
https://leetcode.com/discuss/44792/share-my-o-n-o-1-java-solution
https://leetcode.com/discuss/44789/java-o-n-time-o-1-space
https://leetcode.com/discuss/44741/accepted-java-o-n-solution-with-o-n-memory
*/