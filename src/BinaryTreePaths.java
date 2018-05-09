import java.util.ArrayList;
import java.util.List;

/*
257. Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    //把sting s 做参数可以简化回滚的操作
    void dfs(List<String> res,String s,TreeNode root){
        if(root==null)return;
        if(root.left==null && root.right==null){
            s+=root.val;
            res.add(s);
        }
        //每次传参都是一个崭新的对象，因此不需要回滚；
        dfs(res,s+root.val+"->",root.left);
        dfs(res,s+root.val+"->",root.right);
    }


    //DFS,recurrence
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String s = new String();
        dfs(res,s,root);
        return res;

    }
    void dfs2(List<String> res,StringBuilder s,TreeNode root){
        if(root==null)return;
        if(root.left==null && root.right==null){
            int k=s.length();
            s.append("->"+root.val);
            //["1->2->5->","1->3->"]
//            res.add(s.toString().
//                replaceAll("(.{1})","$1->"));
/**************************split start**************************/
//            StringBuilder t= new StringBuilder();
//            t.append(s.charAt(0));
//
//            for(int i=1;i<s.length();i++)
//                t.append("->"+s.charAt(i));
//            res.add(t.toString());
/**************************split end  **************************/

            res.add(s.toString().substring(2));
            s.delete(k,s.length());
            return;
        }
        int k=s.length();
        s.append("->"+root.val);
        dfs2(res,s,root.left);
        dfs2(res,s,root.right);
//        s.deleteCharAt(s.length()-1);
        s.delete(k,s.length());
        return;

    }
}
