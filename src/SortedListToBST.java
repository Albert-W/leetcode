import java.util.ArrayList;

/*
109. Convert Sorted List to Binary Search Tree
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class SortedListToBST {

    //转化为ArrayList, 3ms;
    public TreeNode sortedListToBST(ListNode head) {

        ArrayList<Integer> a = new ArrayList<>();
        while (head!=null){
            a.add(head.val);
            head=head.next;
        }
        return buildTree(a,0,a.size()-1);
        //Integer[] num=a.toArray(new Integer[a.size()]);//不能转换Integer to int;

        //return buildTree(num,0,num.length-1);


    }

    //优先取小的为根，与答案不一致，也能通过
    TreeNode buildTree(ArrayList<Integer> nums,int s,int e){
        if(s>e)return null;
        int mid=s+(e-s)/2;
        TreeNode root=new TreeNode(nums.get(mid));
        root.left = buildTree(nums,s,mid-1);//不是从0开始的
        root.right = buildTree(nums,mid+1,e);
        return root;
    }



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

}
