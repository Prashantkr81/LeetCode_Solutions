class Solution {
    static int length(Node head){
        int len=0;
        while(head!=null){
            head= head.next;
            len++;
        }
        return len;
    }
    public Node rotate(Node head, int k) {
        if(head==null || head.next == null) return head;

        int len= length(head);
        
        k%= len;
        if(k==0) return head;
        
        Node newHead= null;
        Node temp= head;
        
        for (int i=1; i <k; i++) {
            temp = temp.next;
        }
        
        newHead= temp.next;
        temp.next=null;
        
        temp= newHead;
        
        while(temp.next!=null){
            temp= temp.next;
        }
        temp.next=head;
        
        return newHead;
    }
}
