#
# @lc app=leetcode id=23 lang=python3
#
# [23] Merge k Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeKLists_1(self, lists: List[ListNode]) -> ListNode:
        # divide and conquer
        # 先定义出口
        if len(lists) == 0:
            return None 
        if len(lists) == 1:
            return lists[0]

        l1 = self.mergeKLists(lists[:len(lists)//2])
        l2 = self.mergeKLists(lists[len(lists)//2:])
        return self.mergeTwoLists(l1,l2)

    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        # 重新生成法
        dummy = ListNode(0)
        cur = dummy 
        l = []
        for i in lists:
            while i:
                l.append(i.val)
                i = i.next
        l.sort()
        for j in l:
            cur.next = ListNode(j)
            cur = cur.next 
        return dummy.next                             


    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode(0)
        cur = dummy 
        while l1 and l2 :
            if l1.val > l2.val:
                cur.next = ListNode(l2.val)
                cur = cur.next
                l2 = l2.next 
            else:
                cur.next = ListNode(l1.val)
                cur = cur.next 
                l1 = l1.next 
        if l1 :
            cur.next = l1 
        else: 
            cur.next = l2 
        return dummy.next 
        
# @lc code=end

