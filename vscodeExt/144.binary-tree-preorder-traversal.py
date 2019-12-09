#
# @lc app=leetcode id=144 lang=python3
#
# [144] Binary Tree Preorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if root == None:
            return None
        res = []
        if root.left == None and root.right == None:
            return [root.val]
        res.append(root.val)
        if root.left:
            res.extend( self.preorderTraversal(root.left))
        if root.right:
            res.extend( self.preorderTraversal(root.right))
        return res

    # from others
    def preorderTraversal(self, root: TreeNode) -> List[int]:

        if root == None:
            return []
        else:
            return [root.val] + self.preorderTraversal(root.left) + self.preorderTraversal(root.right)
# @lc code=end

