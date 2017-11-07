/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
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
    public int findBottomLeftValue(TreeNode root) {
        return helper(root, 1, new int[] { 0, 0 });
    }

    public int helper(TreeNode root, int depth, int[] res) {
        if (depth > res[1]) {
            res[0] = root.val;
            res[1] = depth;
        }
        if (root.left != null) {
            helper(root.left, depth + 1, res);
        }
        if (root.right != null) {
            helper(root.right, depth + 1, res);
        }
        return res[0];
    }
}