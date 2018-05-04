/*
83. Remove Duplicates from Sorted List
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode c=head;
        while(c!=null&&c.next!=null){
            //当两个相同时，c不移动；
            if(c.val==c.next.val)
                c.next=c.next.next;
            else c=c.next;
        }
        return head;

    }
}
