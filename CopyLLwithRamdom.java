/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head==null) return null;
        
        HashMap<Node, Node> map= new HashMap<>();

        Node ori= head;
        Node chead= new Node(ori.val);
        Node temp= chead;

        map.put(ori, chead);

        ori= ori.next;

        while(ori!=null){
            Node newNode= new Node(ori.val);
            temp.next = newNode;
            temp = temp.next;
            map.put(ori, newNode);

            ori= ori.next;
        }

        temp= chead;
        ori= head;

        while(ori!=null){
            if(ori.random!=null){
                Node goesTo= map.get(ori.random);
                temp.random= goesTo;
            }
            temp= temp.next;
            ori= ori.next;
        }
        return chead;
    }
}
