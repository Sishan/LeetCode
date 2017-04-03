"""
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
"""

class Queue(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s1 = collections.deque()
        self.s2 = collections.deque()

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        for i in range(len(self.s1)):
            self.s2.append(self.s1.pop())
        self.s1.append(x)
        for i in range(len(self.s2)):
            self.s1.append(self.s2.pop())

    def pop(self):
        """
        :rtype: nothing
        """
        if not self.s1:
            return 
        self.s1.pop()

    def peek(self):
        """
        :rtype: int
        """
        if not self.s1:
            return
        return self.s1[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return not len(self.s1)
