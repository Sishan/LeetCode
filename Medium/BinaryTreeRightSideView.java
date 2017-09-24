/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        rightView(root, res, 0);
        return res;
    }

    public void rightView(TreeNode root, List<Integer> res, int depth) {
        if (root == null)
            return;

        if (depth == res.size()) {
            res.add(root.val);
        }

        rightView(root.right, res, depth + 1);
        rightView(root.left, res, depth + 1);
    }
}