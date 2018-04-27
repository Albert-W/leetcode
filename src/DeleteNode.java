/*
237. Delete Node in a Linked List
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

一个链表中，以某个结点输入，删除链表中的此结点；
 */
//test
//test
public class DeleteNode {
    public void deleteNode(ListNode node) {
        if(node.next==null){
            node=null; //只是形参为NULL而己，不会链表中删除最后的node.
            return;
        }
        node.val=node.next.val;
        node.next=node.next.next;

    }

}
