import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
437. Path Sum III
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
public class PathSum3 {
    //不考虑存储，直接累加；
    //28ms;
    //每个pathSum 都会调用dfs, 优化dfs 就是优化核心；
    public int pathSum(TreeNode root, int sum) {
        if(root==null)return 0;
        int count=0;
        HashMap<Integer,Integer> perSum=new HashMap<>();
        count=dfs(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
        return count;
    }
    int dfs(TreeNode root, int sum){
        if(root==null)return 0;
        int count=0;
        if(root.val==sum){
            count++;
        }
        count+= dfs(root.left,sum-root.val);
        count+= dfs(root.right,sum-root.val);
        return count;

    }





    //DFS;每个结点都可能是开始；
    //时间超限了,但存储了每条路径；
    List<List<Integer>>res = new ArrayList<>();
    List<Integer> temp= new ArrayList<>();
    public int pathSum2(TreeNode root, int sum) {

        //遍历每一个结点；做为开始；
        if(root==null)return res.size();
        dfs(res,temp,root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return res.size();
    }
    void dfs(List<List<Integer>>res,List<Integer> temp,TreeNode root, int sum){
//        List<Integer> temp= new ArrayList<>();
        //设计返回出口：
        //1，空结点；
        //2，叶结点；
        //3, 不一定需要叶结点，值相等就可以；
        if(root==null)return;
        if(root.val==sum){
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            //return;此处不能返回，还有其他可能1，-2，1，-1 ->-1;
        }
        if(root.left==null && root.right==null)return;

//        if(root.left==null && root.right==null){
//            if(root.val==sum) {
//                temp.add(root.val);
//                //res.add(temp);//只是添入了temp的地址而己。
//                //一定要先复制，后存入；
//                res.add(new ArrayList<>(temp));
//                temp.remove(temp.size()-1);
//            }
//            return;
//        }
        temp.add(root.val);
        dfs(res,temp,root.left,sum-root.val);
        dfs(res,temp,root.right,sum-root.val);
        temp.remove(temp.size()-1);
        return;

    }
}
