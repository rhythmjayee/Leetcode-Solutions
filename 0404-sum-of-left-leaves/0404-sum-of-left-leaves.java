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
    public int getSum(TreeNode root, boolean isLeft) {
        if(root == null) return 0;
        if(isLeft && root.left == null && root.right == null) return root.val;
        
        int l = getSum(root.left, true);
        int r = getSum(root.right, false);
        
        return l + r;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return getSum(root, false);
    }
}