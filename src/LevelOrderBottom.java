import java.util.*;

/*
107. Binary Tree Level Order Traversal II
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class LevelOrderBottom {
    //每次从首段插入，可直接逆转顺序；
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int s=q.size();
            while(s-->0){
                TreeNode t=q.poll();
                temp.add(t.val);
                //left 与right 的顺序颠倒可以改变同一行的顺序。
                if(t.left!=null)q.add(t.left);
                if(t.right!=null)q.add(t.right);

            }
            //逆转的关系点；
            res.add(0,temp);

        }
        return res;
    }


    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int s=q.size();
            while(s-->0){
                TreeNode t=q.poll();
                temp.add(t.val);
                //left 与right 的顺序颠倒可以改变同一行的顺序。
                if(t.left!=null)q.add(t.left);
                if(t.right!=null)q.add(t.right);

            }
            res.add(temp);

        }

/**************************reverse start**************************/
        int k=res.size()/2;
        while(k-->0){
            List<Integer> temp=res.get(k);
            res.set(k,res.get(res.size()-1-k));
            res.set(res.size()-1-k,temp);
        }
/**************************reverse end  **************************/
        return res;

    }
}
