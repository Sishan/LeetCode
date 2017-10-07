/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        Stack<Integer> stk = new Stack<Integer>();
        int max = 0;
        int i = 0;
        int[] h = new int[heights.length + 1];
        h = Arrays.copyOf(heights, heights.length + 1);
        while (i < h.length) {
            if (stk.isEmpty() || h[stk.peek()] <= h[i]) {
                stk.push(i++);
            } else {
                int t = stk.pop();
                max = Math.max(max, h[t] * (stk.isEmpty() ? i : i - stk.peek() - 1));
            }
        }
        return max;
    }
}
