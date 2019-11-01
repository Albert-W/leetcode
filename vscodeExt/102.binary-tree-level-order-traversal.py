#
# @lc app=leetcode id=102 lang=python3
#
# [102] Binary Tree Level Order Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return None 
        queue = [root]
        res = []
        while len(queue):
            s = len(queue)
            temp = []
            for i in range(s): 
                temp.append(queue[0].val)
                    # del l[:1]
                if queue[0].left:
                    queue.append(queue[0].left)     
                if queue[0].right:
                    queue.append(queue[0].right)
                del queue[:1]
            res.append(temp)
        return res             
# @lc code=end

