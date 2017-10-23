/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length, maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <=len; i++){
            int height = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || height >= heights[stack.peek()]) stack.push(i);
            else{
                int top = stack.pop();
                // stack.peek() is the last one on the left side that smaller than heights[i]
                // the length to the current position is i - (stack.peek() + 1)
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek())); 
                i--;
            }
        }
        return maxArea;
    }
}

/*
Reference:
http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
*/

/*
Editorial Solution
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        int lastIndex = stack.peek();
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (lastIndex - stack.peek()));
        return maxarea;
    }
}
*/