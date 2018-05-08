import java.util.LinkedList;
import java.util.Queue;

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
    //2ms;39个样例
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int count=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            count++;
            int s= q.size();
            while (s-->0){
                TreeNode t= q.poll();
//                if(t.left==null&&t.right==null)return count;
                if(t.left!=null)q.add(t.left);
                if(t.right!=null)q.add(t.right);
            }

        }
        return count;
    }


    //1ms;
    public int maxDepth2(TreeNode root) {
        if(root==null )
            return 0;
//        if(root.left==null && root.right==null)
//            return 1;
//        if(root.left==null)
//            return maxDepth(root.right)+1;
//        if(root.right==null)
//            return maxDepth(root.left)+1;
        return Math.max(maxDepth2(root.left),maxDepth2(root.right))+1;

    }
}
