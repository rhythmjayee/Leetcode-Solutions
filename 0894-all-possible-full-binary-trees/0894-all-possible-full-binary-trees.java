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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n == 0) {
            ans.add(null);
            return ans;
        } else if(n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        //loop over the number of nodes to used
        //to make subtress on left/right
        for(int i = 1; i <= n - 2; i++) {
            List<TreeNode> l = allPossibleFBT(i);
            List<TreeNode> r = allPossibleFBT(n - i - 1);
            for(TreeNode ll: l) {
                for(TreeNode rr: r) {
                    TreeNode node = new TreeNode(0);
                    node.left = ll;
                    node.right = rr;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}