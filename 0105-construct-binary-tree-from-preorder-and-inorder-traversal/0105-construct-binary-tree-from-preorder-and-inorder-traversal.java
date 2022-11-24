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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return build(inorder, 0, n - 1, preorder, 0, n - 1);
    }
    //in -> L I R
    //pre -> I L R 
    private TreeNode build(int[] in, int i, int j, int[] pre, int k, int l) {
        if(i > j || k > l) return null;
        int val = pre[k];
        TreeNode root = new TreeNode(val);
        int idx = -1;
        //Find preorder kth val in inorder from start
        for(int f = i; f <= j; f++) {
            if(in[f] == val) {
                idx = f;
                break;
            }
        }
        int nodesInLeft = idx - i;
        root.left = build(in, i, idx - 1, pre, k + 1, k + 1 + nodesInLeft - 1);
        root.right = build(in, idx + 1, j, pre, k + 1 + nodesInLeft , l);
        return root;
    }
}