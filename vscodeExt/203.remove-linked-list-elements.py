#
# @lc app=leetcode id=203 lang=python3
#
# [203] Remove Linked List Elements
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        pre = dummy
        cur = head
        while cur:
            if cur.val == val:
                pre.next = cur.next 
                # cur.next = None # 删除多余指向方便垃圾回收。
                del cur
                cur = pre.next 
            else:
                pre = pre.next 
                cur = cur.next
        return dummy.next        


        
# @lc code=end

