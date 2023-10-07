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
        TreeNode prev = null;
        TreeNode curr = root;
        
        while(curr != null) {
            TreeNode left = curr.left;
            TreeNode next = left;
            if(next != null) {
                while(next.right != null && next.right != curr) {
                    next = next.right;
                }
                if(next.right == null) {
                    next.right = curr;
                    curr = left;
                    continue;
                } else {
                    next.right = null;
                }
            }
            if(prev != null && prev.val >= curr.val) return false;
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}