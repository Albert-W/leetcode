#
# @lc app=leetcode id=2 lang=python3
#
# [2] Add Two Numbers
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#            res.next = ListNode(0)
#            res = res.next 

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        res = ListNode(0)
        head = res 
        symb = 0 

        
        while l1 != None or l2 != None or symb != 0:
            s = 0
            res.next = ListNode(0)
            res = res.next 
            s += symb
            if l1:
                s += l1.val
                l1 = l1.next 
            if l2:
                s += l2.val
                l2 = l2.next                  
            if s > 9:
                res.val = s % 10
                symb = 1
            else : 
                res.val = s 
                symb = 0     
        return head.next     


# @lc code=end

