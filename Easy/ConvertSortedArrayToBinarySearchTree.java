/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode head = buildTree(nums, 0, nums.length - 1);
        return head;
    }
    
    public TreeNode buildTree(int[] nums, int left, int right){
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = buildTree(nums, left, mid - 1);
        head.right = buildTree(nums, mid + 1, right);
        return head;
    }
}