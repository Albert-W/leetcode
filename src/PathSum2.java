import java.util.ArrayList;
import java.util.List;

/*
113. Path Sum II
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSum2 {
    //DFS, recurrence;//3ms;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>res = new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        dfs(res,temp,root,sum);
        return res;
    }
    void dfs(List<List<Integer>>res,List<Integer> temp,TreeNode root, int sum){
//        List<Integer> temp= new ArrayList<>();
        //设计返回出口：
        //1，空结点；
        //2，叶结点；
        if(root==null)return;
        if(root.left==null && root.right==null){
            if(root.val==sum) {
                temp.add(root.val);
                //res.add(temp);//只是添入了temp的地址而己。
                //一定要先复制，后存入；
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }
        temp.add(root.val);
        dfs(res,temp,root.left,sum-root.val);
        dfs(res,temp,root.right,sum-root.val);
        temp.remove(temp.size()-1);
        return;

    }


















    //需要全局记录；//4ms;
    //如果全部共同一份记录，则导致记录冗余。
    List<List<Integer>>res = new ArrayList<>();
    List<Integer> temp= new ArrayList<>();

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        if(root==null){
            return res;
        }
        if(root.left==null && root.right==null){
            if(root.val==sum ){
                temp.add(root.val);
                res.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return res;
        };

        temp.add(root.val);
        pathSum2(root.left,sum-root.val);
        pathSum2(root.right,sum-root.val);
        temp.remove(temp.size()-1);
        return res;

    }
}
