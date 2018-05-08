import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
637. Average of Levels in Binary Tree
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageOfLevels {
    //BFS, no need to recurrence;
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            double sum=0;
            //减少循环体的count++,时间减半；
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                TreeNode t = q.poll();
                sum+=t.val;

                if(t.left!=null)q.add(t.left);
                if(t.right!=null)q.add(t.right);

            }
            sum/=s;
            res.add(sum);
        }
        return res;

    }
}
