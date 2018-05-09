/*
112. Path Sum
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


 */
public class HasPathSum {
    //DFS, recurrence
    public boolean hasPathSum(TreeNode root, int sum) {
        //first, the outlet.
//        if(root==null && sum==0)return true;//[],0 为false;
        if(root==null)return false;
//        if(root.val==sum)return true;//[1,2],1 为false;
        //当叶结点值与sum相等时返回true;
        if(root.val==sum && root.left==null && root.right==null)return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);

    }
}
