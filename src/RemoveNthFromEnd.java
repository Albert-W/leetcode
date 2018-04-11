/*
19. Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */

/**
 * Definition for singly-linked list.
 */
//  class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//  }

/*
solution: one pass: set up two nodes which have the exact distance of n.
when one reach the end, the other with nth.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur=head, pre=head;
        while(n!=0){
            pre=pre.next;
            n--;
        }
        //when n is equal to List.length.
        if(pre==null){
            cur=cur.next;
            return cur;
        }
        //normal situation. n is less than the list.length.
        while(pre.next!=null){
            cur=cur.next;
            pre=pre.next;
        }
        cur.next=cur.next.next;
        return head;
    }
}
