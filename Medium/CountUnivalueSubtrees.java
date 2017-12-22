/*
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
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
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    public boolean helper(TreeNode root, int[] res) {
        if (root == null) {
            return true;
        }
        boolean left = helper(root.left, res);
        boolean right = helper(root.right, res);
        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res[0]++;
            return true;
        }
        return false;
    }
}