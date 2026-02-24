// LRU cache implemented using Map and DLL...DLL mainly used for maintaining order or LR and map for getting values or to check where a node/key present in cache or not 

class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key= key;
            this.val= val;
            this.next= null;
            this.prev= null;
        }
    }
    HashMap<Integer, Node> map;
    private int capacity;
    Node head, tail; 
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head= new Node(-1, -1);
        tail= new Node(-1, -1);
        head.next= tail;
        tail.prev= head;
        this.capacity= capacity;
    }
    
    public int get(int key) {

        if(map.containsKey(key)){
            Node temp= map.get(key);
            remove(temp);
            insertAtFront(temp);
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){

            Node node= map.get(key);
            node.val= value;
            remove(node);
            insertAtFront(node);    
        }
        else{
            if(map.size()== capacity ){
                
                Node lru= tail.prev;
                remove(lru);
                map.remove(lru.key);                
            }
                
            Node newNode= new Node(key, value);
            map.put(key, newNode);
            insertAtFront(newNode);
        }
    }

        private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        }

        private void insertAtFront(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
