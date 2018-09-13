/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Consider the following binary search tree: 

     5
    / \
   2   6
  / \
 1   3
Example 1:

Input: [5,2,6,1,3]
Output: false
Example 2:

Input: [5,2,1,3,6]
Output: true
*/

public class Solution {
    public bool VerifyPreorder(int[] preorder) {
        int low = int.MinValue;
        Stack<int> stk = new Stack<int>();
        foreach (int i in preorder)
        {
            if (i < low)
            {
                return false;
            }
            while (stk.Count != 0 && i > stk.Peek())
            {
                low = stk.Pop();
            }
            stk.Push(i);
        }
        return true;
    }
}