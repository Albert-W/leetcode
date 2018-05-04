/*
101. Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isMirrorTree(root.left,root.right);

    }
    //a more compact method
    //尽量提前return, 节省大量时间；
    public boolean isMirrorTree(TreeNode p, TreeNode q) {
        if(p==null && q==null )return true;
        if(p==null || q==null )return false;
        if(p.val!=q.val)return false;
        return isMirrorTree(p.left, q.right) && isMirrorTree(p.right,q.left);
    }
}
