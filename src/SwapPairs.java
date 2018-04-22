/*
24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode left=head,right=head.next;

        head=right; //point to the new head;
        ListNode tail=head;//it's the tail;

        while(left!=null && left.next!=null){ //if the next two node is valid;
            right=left.next;

            //do the change;
            left.next=right.next;
            right.next=left;
            if(tail!=head) //preclude the first case;
                tail.next=right;
            tail=left;


            left=left.next;//go to the next pair.
        }
        return head;

    }
}
