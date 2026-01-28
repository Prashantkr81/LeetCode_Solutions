class Solution {  //optimized Divide and conquer
    ListNode sortedMerge(ListNode head1, ListNode head2){
        ListNode head= new ListNode(0);
        ListNode temp= head;

        while(head1!=null && head2!=null){
            if(head1.val <= head2.val){
                temp.next= head1;
                head1= head1.next;
                temp= temp.next;
            }
            else{
                temp.next=  head2;
                head2= head2.next;
                temp= temp.next;
            }
        }
        while(head1!=null){
            temp.next = head1;
            head1= head1.next;
            temp= temp.next;
        }
        while(head2!=null){
            temp.next= head2;
            head2= head2.next;
            temp=temp.next;
        }
        
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = sortedMerge(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
}

//---------------------------------------------------------------

//merge one by one
class Solution {
    ListNode sortedMerge(ListNode head1, ListNode head2){
        ListNode head= new ListNode(0);
        ListNode temp= head;

        while(head1!=null && head2!=null){
            if(head1.val <= head2.val){
                temp.next= head1;
                head1= head1.next;
                temp= temp.next;
            }
            else{
                temp.next=  head2;
                head2= head2.next;
                temp= temp.next;
            }
        }
        while(head1!=null){
            temp.next = head1;
            head1= head1.next;
            temp= temp.next;
        }
        while(head2!=null){
            temp.next= head2;
            head2= head2.next;
            temp=temp.next;
        }
        
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return null;
        ListNode head = lists[0];

        for(int i=1; i<lists.length; i++){
            head= sortedMerge(head, lists[i]);
        }
        return head;
    }
}
