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
    private Map<String, List<TreeNode>> dp;
    public List<TreeNode> generateTrees(int n) {
        dp = new HashMap<>();
        return dfs(1, n);
    }
    public List<TreeNode> dfs(int low, int high) {
        List<TreeNode> rs = new ArrayList<>();
        if(low > high) {
            rs.add(null);
            return rs;
        } else if(low == high) {
            rs.add(new TreeNode(low));
            return rs;
        } else if(dp.containsKey(low+""+high)) return dp.get(low+""+high);
        
        for(int k = low; k <= high; k++) {
            //use kth node as root node
            //k-1 will be lesser -> should form left subtree
            List<TreeNode> l = dfs(low, k - 1);
            //k+1 will be greater -> should form right subtree
            List<TreeNode> r = dfs(k + 1, high);
            for(TreeNode ll : l) {
                for(TreeNode rr : r) {
                    TreeNode root = new TreeNode(k);
                    root.left = ll;
                    root.right = rr;
                    rs.add(root);
                }
            }
        }
        dp.put(low+""+high, rs);
        return rs;
    }
}