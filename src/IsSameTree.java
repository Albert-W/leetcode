/*
100. Same Tree
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

 */


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class IsSameTree {
    //a more compact method
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null )return true;
        if(p==null || q==null )return false;
        if(p.val==q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }



    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p==null && q==null )return true;
        if(p==null && q!=null)return false;
        if(p!=null && q==null)return false;
        if(p.val!=q.val)return false;
        if(p.val==q.val && p.right==null && q.right==null
            && p.left==null && q.left==null)
            return true;
        return isSameTree2(p.left, q.left) && isSameTree2(p.right,q.right);

    }
}
