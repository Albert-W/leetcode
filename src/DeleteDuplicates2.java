/*
82. Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
 */
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        //首部可能被删，所以新建首部
        ListNode newhead= new ListNode(0);
        newhead.next=head;
        if(head==null|| head.next==null)
            return head;
        ListNode c=newhead;//for current node;
        ListNode f=c.next.next;//for front node;
        //存在两种不等于1，2，3 与1，1，2
        int flag=0;

        while(c!=null && c.next!=null &&f!=null ){
            while (f!=null && c.next.val==f.val){
                f=f.next;
                flag=1;
            }
            if(flag==1){
                c.next=f;
                if(f!=null)
                    f=f.next;
                flag=0;
            }
            else {
                c=c.next;
                f=f.next;
            }

        }
        return newhead.next;

    }
}
