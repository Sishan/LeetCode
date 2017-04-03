/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

public class MinStack {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
    }
    
    public void pop() {
        if (stack.pop().equals(minStack.peek())) minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 
 /*
Stack<T>.Peek Method:
Returns the object at the top of the Stack<T> without removing it

Because you need constant time in retrieving the min element, so you need to keep another stack to store the min element
Can use ArrayList or LinkedList to implement the stack

Hints:
- Consider space-time tradeoff. How would you keep track of the minimums using extra space?
- Make sure to consider duplicate elements.

O(n) runtime, O(n) space – Extra stack:
Use an extra stack to keep track of the current minimum value. During the push operation we choose the new element or the current minimum, 
whichever that is smaller to push onto the min stack.

O(n) runtime, O(n) space – Minor space optimization:
If a new element is larger than the current minimum, we do not need to push it on to the min stack. When we perform the pop operation, 
check if the popped element is the same as the current minimum. If it is, pop it off the min stack too.

Reference:
http://blog.csdn.net/linhuanmars/article/details/41008731
*/
