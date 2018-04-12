/*
21. Merge Two Sorted Lists
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */

public class MergeTwoLists {
    //don't change the value of l1,l2;
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode l = new ListNode(0);
        if(l1.val>l2.val){
            l.next=new ListNode(l2.val);
            l.next.next=mergeTwoLists2(l1,l2.next);
        } else{
            l.next = new ListNode(l1.val);
            l.next.next=mergeTwoLists2(l1.next,l2);
        }
        return l.next;

    }
    //change the original value.
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l= new ListNode(0);
        ListNode c=l;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                c.next = new ListNode(l1.val);
                c=c.next;
                l1=l1.next;

            } else {
                c.next = new ListNode(l2.val);
                c=c.next;
                l2=l2.next;
            }
        }
        if(l1==null){
            c.next = l2;
        } else
            c.next = l1;
        return l.next;
    }
}

