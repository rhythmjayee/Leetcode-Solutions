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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int s = q.size();
            int max = Integer.MIN_VALUE;
            while(s-- > 0) {
                TreeNode rm = q.poll();
                max = Math.max(max, rm.val);
                if(rm.left != null) q.add(rm.left);
                if(rm.right != null) q.add(rm.right);
            }
            ans.add(max);
        }
        return ans;
    }
}