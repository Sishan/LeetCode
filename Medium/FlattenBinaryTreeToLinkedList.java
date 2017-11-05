/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
    public void flatten(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                TreeNode tmp = left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = right;
                node.right = left;
                node.left = null;
            }

            node = node.right;
        }
    }
}

/*
/// SOLUTION I: accepted, recursion ///
public void flatten(TreeNode root) {
    if (root == null)
        return;
    TreeNode left = root.left;
    TreeNode right = root.right;
    if (left != null) {
        TreeNode rightmost = getRightmost(left);
        rightmost.right = right;
        root.left = null; // CATCH: must set left to null explicitly
        root.right = left;
    }
    flatten(root.right);
}

// return the rightmost node of a subtree;
// node must not be null.
private TreeNode getRightmost(TreeNode node) {
    while (node.right != null)
        node = node.right;
    return node;
}
*/