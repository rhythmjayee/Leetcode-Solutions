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
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        return dfs(root)[2];
    }
    public int[] dfs(TreeNode root) {
        //min, max, diff
        int v = root.val;
        int[] ans = new int[]{v, v, 0}; 
        if(root.left != null) {
            int[] l = dfs(root.left);
            ans[2] = Math.max(ans[2], l[2]);
            ans[2] = Math.max(ans[2], Math.max(Math.abs(v - l[0]), Math.abs(v - l[1])));
            ans[0] = Math.min(ans[0], Math.min(l[0], v));
            ans[1] = Math.max(ans[1], Math.max(l[1], v));
        }
        if(root.right != null) {
            int[] r = dfs(root.right);
            ans[2] = Math.max(ans[2], r[2]);
            ans[2] = Math.max(ans[2], Math.max(Math.abs(v - r[0]), Math.abs(v - r[1])));
            ans[0] = Math.min(ans[0], Math.min(r[0], v));
            ans[1] = Math.max(ans[1], Math.max(r[1], v));
        }
        return ans;
    }
}