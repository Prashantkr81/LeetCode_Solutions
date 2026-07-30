class Solution {
    public Node cloneGraph(Node node) {

        if(node == null) return null;
        
        ArrayDeque<Node> q= new ArrayDeque<>();

        HashMap<Node, Node> map= new HashMap<>();

        //copying node
        map.put(node, new Node(node.val));
        q.offer(node);

        while(!q.isEmpty()){
            Node curr= q.poll();

            for(Node neigh: curr.neighbors){
                
                if(!map.containsKey(neigh)){
                    map.put(neigh, new Node(neigh.val));
                    q.offer(neigh);
                }
                // Connect the cloned current node with the cloned neighbor
                map.get(curr).neighbors.add(map.get(neigh));
            }
    
        }
        return map.get(node);
    }
}
