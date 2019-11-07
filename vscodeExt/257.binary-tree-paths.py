#
# @lc app=leetcode id=257 lang=python3
#
# [257] Binary Tree Paths
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        list = []
        if root == None :
            return []
        if root.left == None and root.right == None:
            list.append(str(root.val))
            return list  
        leftList = self.binaryTreePaths(root.left)
        for i in leftList:
            list.append(str(root.val)+'->'+i)

        rightList = self.binaryTreePaths(root.right)
        for i in rightList:
            list.append(str(root.val)+'->'+i)            
        return list                

        
# @lc code=end

