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
    private int totalSum = 0;
    private int MOD = (int)(1e9 + 7);
    public int maxProduct(TreeNode root) {
        Map<TreeNode, Integer> sum = new HashMap<>();
        getSum(root, sum);
        long ans = Math.max(getMax(root.left, sum), getMax(root.right, sum));
        return (int)(ans % MOD);
    }
    private long getMax(TreeNode node, Map<TreeNode, Integer> sum) {
        if(node == null) return 0;
        long max = 0;
        if(node.left != null) {
            long l = getMax(node.left, sum);
            max = Math.max(max, l);
        }
        if(node.right != null) {
            long r = getMax(node.right, sum);
            max = Math.max(max, r);
        }
        
        long sum1 = Math.max(1 , totalSum - sum.get(node));
        long sum2 = Math.max(1, sum.get(node));
        
        long newAns = (sum1 * sum2 );
        
        return Math.max(max, newAns);
    }
    private void getSum(TreeNode root, Map<TreeNode, Integer> sum) {
        if(root == null) return;
        int s = root.val;
        totalSum += root.val;
        
        getSum(root.left, sum);
        getSum(root.right, sum);
        
        if(root.left != null)
            s += sum.get(root.left);
        
        if(root.right != null)
            s += sum.get(root.right);
        
        sum.put(root, s);
    }
}