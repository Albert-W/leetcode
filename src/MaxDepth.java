/*
104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.


 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root==null )
            return 0;
//        if(root.left==null && root.right==null)
//            return 1;
//        if(root.left==null)
//            return maxDepth(root.right)+1;
//        if(root.right==null)
//            return maxDepth(root.left)+1;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
}
