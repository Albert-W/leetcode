/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // Solution1: Turn it into array or List
    // public boolean isPalindrome(ListNode head) {
    //     List<Integer> tmp = toList(head);
    //     for(int i = 0; i < tmp.size() / 2 ; i++) {
    //         if(tmp.get(i) != tmp.get(tmp.size() - 1 -i)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // private List<Integer> toList(ListNode head) {
    //     List<Integer> res = new ArrayList();
    //     while(head != null) {
    //         res.add(head.val);
    //         head = head.next;
    //     }
    //     return res;
    // }

    // Solution2: Put the linked val into a String
    // They should be identical 
    // public boolean isPalindrome(ListNode head) {
    //     StringBuilder left = new StringBuilder("");
    //     StringBuilder right = new StringBuilder("");
        
    //     while(head != null) {
    //         left = left.append(head.val);
    //         right = right.insert(0, head.val);
    //         head = head.next;
    //     }
    //     // System.out.println(left);
    //     // System.out.println(right);
    //     return left.toString().equals(right.toString());

    // }

    // Solution 3: Use the int solution
    // even through there is overflow, but it's okay. 
    public boolean isPalindrome(ListNode head) {
        int left = 0;
        int right = 0;
        int i = 1;
        while(head != null) {
            
            left = left * 10 + head.val;
            right = head.val * i + right;

            head = head.next;
            i = i * 10;
        }
        // System.out.println(left);
        // System.out.println(right);
        return left == right;
    }


}
// @lc code=end

