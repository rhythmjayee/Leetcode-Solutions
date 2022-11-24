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
    private TreeNode first;//first irregular node
    private TreeNode second;//second irregular node
    private TreeNode pre;//last visited node
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        first = null;
        second = null;
        pre = null;
        
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        //if pre not null, check for irregularity
        if(first == null && (pre != null && pre.val > root.val)){
            first = pre;
        }
        //if first not null also means prev not null, check for irregularity
        if(first != null && pre.val > root.val){
            second = root;
        }
        //As we are doing inorder traversal, root will be prev seen node in sorted form
        pre = root;
        inorder(root.right);
    }
}