/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */


//ListNode

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

    //1. when you do not know how to deal with the head point.
    //just save another one, leap once at the end.
   //2. HairCut Method: when two line have different length. cut one make them looks like at the same length.
public class AddTwoNumbers {
        class Solution {
            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                ListNode L3 = new ListNode(0);
                ListNode T1=l1, T2=l2,T3=L3;
                int s1=0,s2=0,s3=0;
                while(T1!=null || T2!=null){
                    if(T1!=null){
                        s1=T1.val;
                    } else s1=0;
                    if(T2!=null){
                        s2=T2.val;
                    } else s2=0;

                    if(T3.next==null){
                        T3.next = new ListNode((s1+s2+s3)%10);
                    } else {
                        T3.next.val=(s1+s2+s3)%10;
                    }
                    if(s1+s2+s3>9){
                        s3 = 1;
                    } else {
                        s3 = 0;
                    }
                    if(T1!=null) T1=T1.next;
                    if(T2!=null) T2=T2.next;
                    T3=T3.next;
                    if(s3==1){
                        T3.next = new ListNode(1);
                    }
                }
                L3=L3.next;
                return L3;
            }
        }

}
