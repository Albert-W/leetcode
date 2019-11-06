#
# @lc app=leetcode id=112 lang=python3
#
# [112] Path Sum
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if root == None :
            return False    
        # [1,2]1 Expected false 
        # 必须是叶子节点   
        if root.left == None and root.right == None:
            return root.val == sum 

        return self.hasPathSum(root.left, sum - root.val) or self.hasPathSum(root.right, sum - root.val)

        
# @lc code=end

