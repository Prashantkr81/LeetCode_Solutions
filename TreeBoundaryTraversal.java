class Solution {
    void leftBoundary(Node root, ArrayList<Integer> ans){
        
        root= root.left;
        
        while(root!=null){
            
            if (!(root.left==null && root.right==null))
                ans.add(root.data);
            if(root.left!=null)
                root= root.left;
            else 
                root= root.right;
        }
    }
    
    void leaf(Node root, ArrayList<Integer> ans){
        
        if(root==null) return;
        
        leaf(root.left, ans);
        if(root.left==null && root.right==null) ans.add(root.data);
        leaf(root.right, ans);
    }
    
    void rightBoundary(Node root, ArrayList<Integer> ans){
        Stack<Integer> stk= new Stack<>();
        
        root= root.right;
        
        while(root!=null){
            if (!(root.left==null && root.right==null))
                stk.push(root.data);
            if(root.right!=null)
                root= root.right;
            else 
                root= root.left;
        }
        
        while(!stk.isEmpty()) ans.add(stk.pop());
    }
    
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> ans= new ArrayList<>();
        if(root == null) return ans;
        
        ans.add(root.data);
        
        if(root.left == null && root.right == null)
            return ans; 
        
        leftBoundary(root, ans);
        leaf(root, ans);
        rightBoundary(root, ans);
        
        return ans;
        
    }
}
