/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur = head;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre; //关键的逆序操作
            pre = cur;
            cur = next;
        }
        return pre;
        
    }
}
// @lc code=end

