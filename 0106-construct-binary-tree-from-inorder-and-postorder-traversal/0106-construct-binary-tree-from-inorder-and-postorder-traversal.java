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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return build(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    //in -> L I R
    //pos -> L R I
    private TreeNode build(int[] in, int i, int j, int[] pos, int k, int l) {
        if(i > j || k > l) return null;
        int val = pos[l];
        TreeNode root = new TreeNode(val);
        int idx = -1;
        //Find postorder lth val in inorder from start
        for(int f = i; f <= j; f++) {
            if(in[f] == val) {
                idx = f;
                break;
            }
        }
        int nodesInLeft = idx - i;
        root.left = build(in, i, idx - 1, pos, k, k + nodesInLeft - 1);
        root.right = build(in, idx + 1, j, pos, k + nodesInLeft , l - 1);
        return root;
    }
}