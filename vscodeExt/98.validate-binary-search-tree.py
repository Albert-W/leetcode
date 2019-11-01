#
# @lc app=leetcode id=98 lang=python3
#
# [98] Validate Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        # 出口
        if root == None:
            return True 
        if root.left == None and root.right == None:
            return True 
        # 必须用子树中的最小最大值，与root比较。 
        # 左子树找到最大值与root 比较    
        if root.left:
            max = root.left.val   
            cur = root.left
            while cur:
                max = cur.val 
                cur = cur.right
            if max >= root.val:
                return False 
        
        # 右子树找到最小值与root 比较
        if root.right:
            min = root.right.val 
            cur = root.right 
            while cur: 
                min = cur.val 
                cur = cur.left 
            if min <= root.val:
                return False     

        return self.isValidBST(root.left) and self.isValidBST(root.right)        
            

        
# @lc code=end

