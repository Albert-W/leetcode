import java.util.*;

/*
102. Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 */
public class LevelOrder {
    //BFS, 不需要用到递归。
    //共用一个列表；
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> q= new LinkedList<>(); //如果存在null, size()不为0；
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();

            int s = q.size();//在for循环中，q的size的变化；
            for(int i=0;i<s;i++){
                TreeNode t=q.poll();//Retrieves and removes the head of this queue
                    temp.add(t.val);
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);

            }
            res.add(temp);

        }
        return res;

    }

}
