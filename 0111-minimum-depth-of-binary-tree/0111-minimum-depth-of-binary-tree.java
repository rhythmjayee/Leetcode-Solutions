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
    public int minDepth(TreeNode root) {
      int h = get(root);
      return h == Integer.MAX_VALUE ? 0 : h;
    }
    public int get(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        else if(root.left == null && root.right == null) return 1;

        int left = get(root.left);
        int right = get(root.right);
        int min = Math.min(left,right);
        return min == Integer.MAX_VALUE ? min : min + 1;
    }
}