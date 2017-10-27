/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
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
    private int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return maxLen;
        }
        helper(root, 0, root.val);
        return maxLen;
    }

    private void helper(TreeNode node, int len, int target) {
        if (node == null) {
            return;
        }
        if (node.val == target) {
            len++;
        } else {
            len = 1;
        }
        maxLen = Math.max(maxLen, len);
        helper(node.left, len, node.val + 1);
        helper(node.right, len, node.val + 1);
    }
}

/*
public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        return longestConsecutive(root, null, 0);
    }
    public int longestConsecutive(TreeNode root, TreeNode prev, int len) {
        if(root == null)
            return len; // reached the leaf node.

        int leftLen = 0, rightLen = 0;
        if(prev != null && root.val == prev.val + 1) { // Increasing node found
            leftLen = longestConsecutive(root.left, root, len + 1);
            rightLen = longestConsecutive(root.right, root, len + 1);
        }
        else { // This node breaks the increasing property. So start again from here.
            leftLen = Math.max(len, longestConsecutive(root.left, root, 1));
            rightLen = Math.max(len, longestConsecutive(root.right, root, 1));
        }

            
        return Math.max(leftLen, rightLen);
        
    }
*/