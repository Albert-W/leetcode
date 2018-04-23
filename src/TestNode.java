public class TestNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode cur=head;
        for(int i=0;i<4;i++){
            cur.next=new ListNode(i+5);
            cur = cur.next;

        }
        cur=head;
        while(cur.next!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
        new DeleteNode().deleteNode(cur);
        cur=head;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
