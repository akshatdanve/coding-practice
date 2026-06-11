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
class binaryTreePostorderTraversal.java {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        func(root, res);
        return res;
    }

    public void func(TreeNode root, ArrayList<Integer> res){
        if(root==null){
            return;
        }
        if(root.left!=null){
            func(root.left, res);
        }
        if(root.right!=null){
            func(root.right, res);
        }
        res.add(root.val);
    }
}
