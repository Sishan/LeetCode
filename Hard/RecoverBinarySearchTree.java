/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    public void recoverTree(TreeNode root) {
        TreeNode pre = null, first = null, second = null;
        TreeNode tmp = null;
        while (root != null) {
            if (root.left == null) {
                if (pre != null && pre.val > root.val) {
                    if (first == null) {
                        first = pre;
                        second = root;
                    } else {
                        second = root;
                    }
                }
                pre = root;
                root = root.right;
            } else {
                tmp = root.left;
                while (tmp.right != null && tmp.right != root) {
                    tmp = tmp.right;
                }
                if (tmp.right != null) {
                    if (pre != null && pre.val > root.val) {
                        if (first == null) {
                            first = pre;
                            second = root;
                        } else {
                            second = root;
                        }
                    }
                    pre = root;
                    tmp.right = null;
                    root = root.right;
                } else {
                    tmp.right = root;
                    root = root.left;
                }
            }
        }
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}