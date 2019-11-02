#
# @lc app=leetcode id=206 lang=python3
#
# [206] Reverse Linked List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        pre = None
        cur = head
        while cur:
            nex = cur.next # 新建nex 是 cur 的一下位

            cur.next = pre # cur 的逆转
            pre = cur # pre 前移
            cur = nex # cur 前移
        # 当 cur 为空后，pre是第一个元素
        return pre
        
# @lc code=end

