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
    public int getSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;
        while(!q.isEmpty()) {
            TreeNode tn = q.poll();
            if(tn.left != null && tn.left.left == null && tn.left.right == null) {
                sum += tn.left.val;
            }
            if(tn.left != null) q.add(tn.left);
            if(tn.right != null) q.add(tn.right);
        }
        return sum;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return getSum(root);
    }
}