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
    int[] h, l, r;
    // Store the height of each node's left and right child
    public int height(TreeNode root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        l[root.val] = lh;
        r[root.val] = rh;

        return 1+Math.max(lh, rh);
    }
    // Store the max height of each node if deleted
    public void solve(TreeNode root, int curmax, int depth){
        if(root == null) return;

        h[root.val] = curmax;
        //max of (current depth + right/left height, maxSoFar)
        solve(root.left, Math.max(curmax, depth+r[root.val]), depth+1);
        solve(root.right, Math.max(curmax, depth+l[root.val]), depth+1);
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        //stores the max height of tree if ith node deleted
        h = new int[100001];
        //stores height of left, right node of ith node
        l = new int[100001];
        r = new int[100001];

        height(root);
        solve(root.left, r[root.val], 1);
        solve(root.right, l[root.val], 1);

        int n = queries.length;
        int[] q = new int[n];
        for(int i=0; i<n; i++){
            q[i] = h[queries[i]]; //Query in O(1)
        }
        return q;
    }
}