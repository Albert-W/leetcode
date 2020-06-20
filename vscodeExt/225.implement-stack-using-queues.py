#
# @lc app=leetcode id=225 lang=python3
#
# [225] Implement Stack using Queues
#

# @lc code=start
import queue
class MyStack:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.q = queue.Queue()
        

    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """
        self.q.put(x)
        

    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        nq = queue.Queue()
        while self.q.qsize() > 1:
            nq.put(self.q.get())
        r = self.q.get()    
        self.q = nq     
        return r
        

    def top(self) -> int:
        """
        Get the top element.
        """
        nq = queue.Queue()
        while self.q.qsize() > 1:
            nq.put(self.q.get())
        r = self.q.get()
        nq.put(r)    
        self.q = nq     
        return r        
        

    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """
        return self.q.empty()
        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()
# @lc code=end

