/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
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
    public boolean isValidBST(TreeNode root) {
        return isValidChecker(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidChecker(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val >= max || root.val <= min)
            return false;
        return isValidChecker(root.left, min, root.val) && isValidChecker(root.right, root.val, max);
    }
}

/*
class Solution {
    class BSTIterator{
        stack<TreeNode *> s;
        void update(TreeNode *cur){
            while(cur){
                s.push(cur);
                cur = cur->left;
            }
        }
    public: 
        BSTIterator(TreeNode *root){
             update(root);
        }
        
        bool hasNext(){
            return !s.empty();
        }
        
        TreeNode* next(){
            if(!hasNext()) return NULL;
            TreeNode *t = s.top();
            s.pop();
            update(t->right);
            return t;
        }
    };
public:
    bool isValidBST(TreeNode *root) {
        BSTIterator iterator(root);
        int prev = INT_MIN;
        while (iterator.hasNext()) {
            int curr = iterator.next()->val;
            if (prev >= curr) {
                return false;
             }
             prev = curr;
        }
        return true;
    }
};
*/