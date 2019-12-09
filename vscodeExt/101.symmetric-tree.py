#
# @lc app=leetcode id=101 lang=python3
#
# [101] Symmetric Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        return self.isMirror(root.left, root.right)    

    # p,q 互为镜像
    def isMirror(self, p, q):
        if p == None and q == None:
            return True
        if p == None or q == None:
            return False
        return p.val == q.val and self.isMirror(p.left, q.right) and self.isMirror(p.right, q.left)            
# @lc code=end

