/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(0, inorder.length - 1, postorder.length - 1, postorder, inorder);
    }

    public TreeNode build(int inStart, int inEnd, int postEnd, int[] postorder, int[] inorder) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }

        root.left = build(inStart, idx - 1, postEnd - (inEnd - idx) - 1, postorder, inorder);
        root.right = build(idx + 1, inEnd, postEnd - 1, postorder, inorder);

        return root;
    }
}