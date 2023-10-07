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
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> sk = new LinkedList<>();
        
        //inorder of BST -> sorted order
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null || !sk.isEmpty()) {
            while(curr != null) {
                sk.addLast(curr);
                curr = curr.left;
            }
            TreeNode top = sk.removeLast();
            if(prev != null && top.val <= prev.val) return false;
            else {
                prev = top;
            }
            curr = top.right;
        }
        return true;
    }
}