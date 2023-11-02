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
    public int averageOfSubtree(TreeNode root) {
        return dfs(root)[2];
    }
    //[total_nodes_count, sum, valid_nodes_count]
    public int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0, 0};
        }
        int[] left_ans = dfs(root.left);
        int[] right_ans = dfs(root.right);
        
        int[] ans = new int[3];
        int count = left_ans[0] + right_ans[0] + 1;
        int sum = left_ans[1] +  right_ans[1] + root.val;
        
        ans[0] = count;
        ans[1] = sum;
        ans[2] = left_ans[2] + right_ans[2];
        int avg = (int)Math.ceil(sum / count);
        // System.out.println(sum +" "+count+" "+avg + " "+root.val);
        if(avg == root.val) {
            ans[2]++;
        }
        return ans;
    }
}