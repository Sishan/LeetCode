/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int left = countNode(root.left);
        if (left + 1 == k) {
            return root.val;
        } else if (left + 1 < k) {
            return kthSmallest(root.right, k - left - 1);
        } else {
            return kthSmallest(root.left, k);
        }
    }

    private int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNode(root.left) + countNode(root.right);
    }
}