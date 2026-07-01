/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class binaryTreeIsCousins {
    int depth=0;
    int findDepth(TreeNode root, int target, int depth){
        if(root==null){
            return -1;
        }
        if(root.val==target){
            return depth;
        }
        int left = findDepth(root.left, target, depth+1); //search for the target in left subtree
        if(left!=-1){
            return left; //search recursively until ".left" is null (no left)
        }
        return findDepth(root.right, target, depth+1); //recursively search the right tree similarly 
    }
    TreeNode findParent(TreeNode root, int target){
        if(root==null){
            return root;
        }
        if(root.left!=null && root.left.val==target){
            return root;
        }
        if(root.right!=null && root.right.val==target){
            return root;
        }
        TreeNode left=findParent(root.left,target);
        if(left!=null){
            return left;
        }
        return findParent(root.right, target);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        int depthX=findDepth(root, x, depth);
        int depthY=findDepth(root, y, depth);
        TreeNode parentX=findParent(root, x);
        TreeNode parentY=findParent(root, y);
        if(depthX==depthY && parentX.val!=parentY.val){
            return true;
        }
        return false;
    }

}
