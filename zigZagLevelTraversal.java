class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result= new ArrayList<>();
        if(root==null) return result;

        ArrayDeque<TreeNode> queue= new ArrayDeque<>();
        queue.offer(root);

        boolean leftToRight= true;
        while(!queue.isEmpty()){
            LinkedList<Integer> temp= new LinkedList<>();
            int sz= queue.size();

            for(int i=0; i<sz; i++){
                TreeNode curr= queue.poll();
                
                if(leftToRight) temp.add(curr.val);
                else temp.addFirst(curr.val);

                if(curr.left!=null)  queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            result.add(temp);
            leftToRight= !leftToRight;
        }
        return result;
    }
}
