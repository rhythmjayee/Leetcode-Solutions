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
    private int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return formBST(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private TreeNode formBST(int[] pre, int max, int min) {
        if(idx == pre.length) return null;
        else if(pre[idx] < min || pre[idx] > max) return null;
        
        TreeNode root = new TreeNode(pre[idx++]);
        root.left = formBST(pre, root.val, min);
        root.right = formBST(pre, max, root.val);
        
        return root;
    }
}