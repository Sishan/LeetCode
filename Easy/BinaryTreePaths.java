/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:
["1->2->5", "1->3"]


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) return res;
        String path = String.valueOf(root.val);
        getPath(root, path, res);
        return res;
    }
    
    public void getPath(TreeNode root, String path, List<String> res){
        if (root.left == null && root.right == null) res.add(path);
        else {
            if (root.left != null) getPath(root.left, path + "->" + root.left.val, res);
            if (root.right != null) getPath(root.right, path + "->" + root.right.val, res);
        }
    }
}