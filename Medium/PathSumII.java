/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        pathSum(root, sum, cur, res);
        return res;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        cur.add(new Integer(root.val));
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);
            return;
        } else {
            pathSum(root.left, sum - root.val, cur, res);
            pathSum(root.right, sum - root.val, cur, res);
        }
        cur.remove(cur.size() - 1);
    }
}