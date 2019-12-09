#
# @lc app=leetcode id=100 lang=python3
#
# [100] Same Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if p == None and q == None :
            return True
        if p == None or q == None:
            return False    
        return p.val == q.val and self.isSameTree(p.left,q.left) and self.isSameTree(p.right,q.right)    
        
# @lc code=end

