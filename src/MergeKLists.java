import java.util.Arrays;

/*
23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null; //because of the given example, [] returns [];
        if(lists.length==1)
            return lists[0];

        ListNode l1 = mergeKLists(Arrays.copyOfRange(lists,0,lists.length/2));
        ListNode l2 = mergeKLists(Arrays.copyOfRange(lists,lists.length/2,lists.length));

        return mergeTwoLists(l1,l2);

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
