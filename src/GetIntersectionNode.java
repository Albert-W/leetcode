/*
160. Intersection of Two Linked Lists
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class GetIntersectionNode {
    //a+b=b+a;
    //too many if; 2ms;
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check;
        //if one list is null; it will never end at a==b==null;
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        //it will ends when a==b==null;
        while (a != b) {
            if (a == null) a = headB;
            else a = a.next;
            if (b == null) b = headA;
            else b = b.next;
        }
        return a;
    }


    //count the length;1ms;
    //O(m+n),O(1);
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int count = 0;
        while (a != null) {
            count++;
            a = a.next;
        }
        while (b != null) {
            count--;
            b = b.next;
        }
        a = headA;
        b = headB;
        while (count > 0) {
            a = a.next;
            count--;
        }
        while (count < 0) {
            b = b.next;
            count++;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;

    }
}
