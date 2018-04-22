import java.lang.annotation.Target;
import java.util.Stack;

/*
25. Reverse Nodes in k-Group
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseKGroup {
    public ListNode reverseKGroup2(ListNode head, int k) {
        if(head==null||k<2)
            return head;
        ListNode left=head,right=head;
        ListNode tail=head;

        Stack<ListNode> stack = new Stack<>();

        while(left!=null){
            int i=1;
            while(i<k && right!=null){
                stack.push(right);
                right=right.next;
                i++;
            }
            if(i<k||right==null)return head;
            stack.push(right);

            //do the change
            left.next=right.next;
            while (stack.size()!=1){
                stack.pop().next=stack.peek();
            }
            stack.pop(); //the general stack has to be empty in every loop.
            if(head ==tail){
                head = right; //if it's the first loop
            } else tail.next=right;

            tail=left;
            left=left.next;
            right = left;


        }
        return head;

    }

}
