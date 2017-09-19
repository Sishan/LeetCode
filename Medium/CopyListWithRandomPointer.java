/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        
        RandomListNode node = head;             // first round scan, copy value of each node and put it behind the original node
        while (node != null){                   // e.g. 1->2->3->4 to become 1->1'->2->2'->3->3'->4->4'
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        
        node = head;                            // second round scan, to give the randome pointer for each copied node
        while (node != null){
            if (node.random != null) node.next.random = node.random.next;
            node = node.next.next;
        }
        
        RandomListNode newHead = head.next;    


        node = head;                             // third round scan, to separate all copied nodes to form new linkedlist
        while (node != null){
            RandomListNode newNode = node.next;
            node.next = newNode.next;
            if (newNode.next != null) newNode.next = newNode.next.next;
            node = node.next;
        }
        return newHead;
    }
}

/*
Reference:
http://blog.csdn.net/ljiabin/article/details/39054999
*/