#
# @lc app=leetcode id=101 lang=python3
#
# [101] Symmetric Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool: 
        if not root:
            return True
        queue = [root.left, root.right]
        while queue:
            right = queue.pop()
            left = queue.pop()
            if not left and not right:
                continue
            if not left or not right:
                return False
            if left.val != right.val:
                return False
            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)
        return True
                
    
    def isSymmetric_Recursion(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        return self.isMirrored(root.left, root.right)
        
    def isMirrored(self, left, right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        return left.val == right.val and self.isMirrored(left.left, right.right) and self.isMirrored(left.right, right.left)
        
# @lc code=end

