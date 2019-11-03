#
# @lc app=leetcode id=19 lang=python3
#
# [19] Remove Nth Node From End of List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        #间隔n+1次，得到待删前一个节点
        # 被删除可以是第一个节点
        dummy = ListNode(0)
        dummy.next = head
        p = dummy
        q = p.next
        for i in range(n):
            q = q.next
        while q:
            p = p.next
            q = q.next
        p.next = p.next.next
        return dummy.next        

        
# @lc code=end

