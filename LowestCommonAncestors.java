class Solution {
    int depth(TreeNode root){
        if(root==null) return 0;
        return 1+ Math.max(depth(root.left), depth(root.right));
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depthLeft= depth(root.left);
        int depthRight= depth(root.right);

        if(depthLeft == depthRight) return root;

        if(depthLeft > depthRight) return lcaDeepestLeaves(root.left);

        return lcaDeepestLeaves(root.right);
    }
}
