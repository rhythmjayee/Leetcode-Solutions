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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> sk = new Stack<>();
        
        sk.push(root);
        sk.push(root);
        
        while(!sk.isEmpty()) {
            TreeNode r1 = sk.pop();
            TreeNode r2 = sk.pop();
            if(r1 == null && r2 == null) continue;
            else if(r1 == null || r2 == null) return false;
            else if(r1.val != r2.val) return false;
            
            sk.push(r1.left);
            sk.push(r2.right);
            
            sk.push(r1.right);
            sk.push(r2.left);
        }
        return true;
    }
}