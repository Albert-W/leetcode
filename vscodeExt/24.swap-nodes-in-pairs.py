#
# @lc app=leetcode id=24 lang=python3
#
# [24] Swap Nodes in Pairs
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head 
        p= dummy 
        while p.next and p.next.next:
            node1 = p.next
            node2 = node1.next
            next = node2.next 
            node1.next = next 
            node2.next = node1 
            p.next = node2 
            p = node1
        return dummy.next    







# @lc code=end

