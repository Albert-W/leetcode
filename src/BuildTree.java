/*
[5,4,8,11,null,13,4,7,2,null,null,5,1]
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
按层序建树；
 */


import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
    TreeNode buildTree(int[] nums){
        //BFS, 需要利用queue;
        //需要一个标记位,标记null;
        int mark=0;
        Queue<TreeNode> q= new LinkedList();
        TreeNode head=new TreeNode(nums[0]);
        q.add(head);
        int index=1;
        while(index<nums.length){
            TreeNode t=q.poll();
            if(nums[index]!=mark){
                t.left=new TreeNode(nums[index++]);
                q.add(t.left);
            } else index++;
            if(nums[index]!=mark) {
                t.right = new TreeNode(nums[index++]);
                q.add(t.right);
            } else index++;

        }
        return head;

    }
}
