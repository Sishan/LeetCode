/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (! queue.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i ++){
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) queue.offer(head.left);
                if (head.right != null) queue.offer(head.right);
            }
            res.add(0,level);
        }
        return res;
    }
}


/*
Similar to Binary Tree Zigzag Level Order Traversal - https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Analysis:
Use the proper of stack and queue. Stack: last in first out, queue: first in first out

这道题和Binary Tree Level Order Traversal很类似，都是层序遍历一棵树，只是这道题要求从最底层往最上层遍历。
这道题我没有想到什么好的做法可以一次的自底向上进行层序遍历，能想到的就是进行Binary Tree Level Order Traversal中的遍历，
然后对结果进行一次reverse。时间上和空间上仍是O(n)

Reference:
(Binary Tree Traversal总结)https://yusun2015.wordpress.com/2015/01/05/binary-tree-traversal/
http://www.ninechapter.com/solutions/binary-tree-level-order-traversal-ii/
http://blog.csdn.net/linhuanmars/article/details/23414711
*/