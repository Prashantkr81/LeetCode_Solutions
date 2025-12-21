class Solution {
    int result=0;
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    private void inorder(TreeNode root, int depth, int curr){
        if(root==null) return;

        inorder(root.left, depth, curr+1);
        if(curr==depth) result+=root.val;
        inorder(root.right, depth, curr+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        
        int depth= maxDepth(root);
        inorder(root, depth, 1);
        return result;
    }
}
