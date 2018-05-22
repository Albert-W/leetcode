/*
110. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */

//一定要多用变量做中间存储；
public class IsBalanced {
    //利用变量存储，时间爆减为2ms;
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        return balanceDepth(root) != -1;

    }
    public int balanceDepth(TreeNode root) {
        if(root==null )
            return 0;
        int l =balanceDepth(root.left),
            r =balanceDepth(root.right);
        if(l==-1 ||r==-1
            ||Math.abs(l-r)>1)
            return -1;

        return Math.max(l,r)+1;

    }


    //使用一层递归；在原Depth函数上进行判断；865ms;
    //一下子展开了四层，时间爆炸了；
    public boolean isBalanced3(TreeNode root) {
        if(root==null)return true;
        return balanceDepth3(root) != -1;

    }
    public int balanceDepth3(TreeNode root) {
        if(root==null )
            return 0;
        if(balanceDepth3(root.left)==-1 ||balanceDepth3(root.right)==-1
            ||Math.abs(balanceDepth3(root.left)-balanceDepth3(root.right))>1)
            return -1;

        return Math.max(balanceDepth3(root.left),balanceDepth3(root.right))+1;

    }




    //使用了两层性质相同的递归，比较浪费。
    //4ms;
    public boolean isBalanced2(TreeNode root) {
        if(root==null)return true;
        if(Math.abs( maxDepth2(root.left)-maxDepth2(root.right))>1)
            return false;
        return isBalanced2(root.right) && isBalanced2(root.left);

    }
    public int maxDepth2(TreeNode root) {
        if(root==null )
            return 0;
        return Math.max(maxDepth2(root.left),maxDepth2(root.right))+1;

    }
}
