class Solution {
    static class pair{
        Node node;
        int colm;
        pair(Node node, int colm){
            this.node= node;
            this.colm= colm;
        }
    }
    
    public ArrayList<Integer> topView(Node root) {
        // code here
        Map<Integer, Integer> column= new TreeMap<>();
        
        ArrayDeque<pair> queue= new ArrayDeque<>();
        
        int center=0;
        
        pair pr= new pair(root, center);
        queue.add(pr);
        
        while(!queue.isEmpty()){
            
            int sz= queue.size();
            
            for(int i=0; i<sz; i++){
                pair curr= queue.poll();
                
                if(!column.containsKey(curr.colm))
                column.put(curr.colm, curr.node.data);
                
                if(curr.node.left!=null) queue.add(new pair(curr.node.left, curr.colm-1));
                if(curr.node.right!=null) queue.add(new pair(curr.node.right, curr.colm+1));
            }
        }
        
        ArrayList<Integer> ans= new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: column.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
