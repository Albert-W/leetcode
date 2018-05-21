/*
142. Linked List Cycle II
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 */
public class DetectCycle {
    //***Floyd cycle detection method***
    //time complexity O(m+n) space complexity O(1);
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = slow.next;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != fast) return null;
        //fast 已经另作他用。
        fast = head;
        //slow 为了保持同步+1；
        slow = slow.next;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
