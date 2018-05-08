import java.util.LinkedList;
import java.util.Queue;

/*
111. Minimum Depth of Binary Tree
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        int count=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            count++;
            int s= q.size();
            while (s-->0){
                TreeNode t= q.poll();
                if(t.left==null&&t.right==null)return count;
                if(t.left!=null)q.add(t.left);
                if(t.right!=null)q.add(t.right);
            }

        }
        return count;

    }
}
