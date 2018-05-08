/*
108. Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class SortedArrayToBST {
    //建树是个递归过程
    //中间为根，左右为枝
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return buildTree(nums,0,nums.length-1);

    }
    //优先取小的为根，与答案不一致，也能通过
    TreeNode buildTree(int[] nums,int s,int e){
        if(s>e)return null;
        int mid=s+(e-s)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left = buildTree(nums,s,mid-1);//不是从0开始的
        root.right = buildTree(nums,mid+1,e);
        return root;
    }


    TreeNode buildTree2(int[] nums,int s,int e){
        if(s>e)return null;
        int mid=0;
        //优先取大的为根；
        if((e-s)%2==0)mid=s+(e-s)/2;
        else mid =s+(e-s)/2+1;
        TreeNode root=new TreeNode(nums[mid]);
        root.left = buildTree(nums,s,mid-1);//不是从0开始的
        root.right = buildTree(nums,mid+1,e);
        return root;
    }
}
