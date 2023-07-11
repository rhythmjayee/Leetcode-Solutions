/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, target, k, res);
        return res;
    }
    public void getAllNodeDistK(TreeNode node, int k, List<Integer> res) {
        if(k < 0 || node == null) return;
        else if(k == 0) {
            res.add(node.val);
            return;
        }
        getAllNodeDistK(node.left, k - 1, res);
        getAllNodeDistK(node.right, k - 1, res);
    }
    public int dfs(TreeNode root, TreeNode t, int k, List<Integer> res) {
        if(root == null) return -1;
        else if(root.val == t.val) {
            getAllNodeDistK(root, k, res);
            return 1;
        }
        
        int lft = dfs(root.left, t, k, res);
        if(lft != -1) {
            if(lft == k) res.add(root.val);
            getAllNodeDistK(root.right, k - lft - 1, res);
            return lft + 1;
        }
        
        int rght = dfs(root.right, t, k, res);
        if(rght != -1) {
            if(rght == k) res.add(root.val);
            getAllNodeDistK(root.left, k - rght - 1, res);
            return rght + 1;
        }
        return -1;
    }
}