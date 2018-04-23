/*
203. Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)return head;
        while(head!=null && head.val==val){
            head=head.next;
        }
        ListNode cur=head;
        while (cur!=null){
            if(cur.next!=null && cur.next.val==val){
                cur.next=cur.next.next;
            }
            else cur=cur.next;
        }
        return head;

    }
}
