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
    public int maxPathSum(TreeNode root) {
        return get(root)[1];
    }
    private int[] get(TreeNode root) {
        if(root == null) return new int[]{-1001, -1001};
        else if(root.left == null && root.right == null) return new int[]{root.val, root.val};
        
        int[] l = get(root.left);
        int[] r = get(root.right);
        
        int overAllMax = -1001;
        int pathFromLeft = l[0] + root.val;
        int pathFromRight = r[0] + root.val;
        int pathLeftToRight = l[0] + r[0] + root.val;
        int overAllMaxLeft = l[1];
        int overAllMaxRight = r[1];
        //root only, root+left, root+right, root+left+right, left only, right only
        overAllMax = Math.max(root.val, Math.max(overAllMaxLeft, Math.max(overAllMaxRight, Math.max(pathLeftToRight, Math.max(pathFromRight, pathFromLeft)))));
        //root With left or root With right or Only root
        int maxPathFromRoot = Math.max(root.val, Math.max(pathFromLeft, pathFromRight));
        return new int[]{maxPathFromRoot, overAllMax};
    }
}