/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
    public int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + height(root.left);
    }

    public int countNodes(TreeNode root) {
        int h = height(root);
        int node = 0;
        while (root != null) {
            if (height(root.right) == h - 1) {
                node += 1 << h;
                root = root.right;
            } else {
                node += 1 << (h - 1);
                root = root.left;
            }
            h--;
        }
        return node;
    }
}