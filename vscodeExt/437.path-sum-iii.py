#
# @lc app=leetcode id=437 lang=python3
#
# [437] Path Sum III
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 不一定从根开始的，不一定要叶子的路径
    def pathSum(self, root: TreeNode, sum: int) -> int:
        count = 0 
        if root == None:
            return 0 
        # 从root 出发的所有可能
        count += self.findPath(root, sum)
        # 不包含root 的 所有可能。 
        count += self.pathSum(root.left, sum) + self.pathSum(root.right, sum)
        return count

    # 从root 出发的所有路径数             
    def findPath(self, root, sum):
        count = 0
        if root == None:
            return 0
        if root.val == sum:
            count += 1
        count += self.findPath(root.left, sum-root.val) + self.findPath(root.right, sum-root.val)
        return count        


# @lc code=end

