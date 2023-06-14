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
    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> sk = new LinkedList<>();
        Integer prev = null;
        int min = Integer.MAX_VALUE;
        TreeNode cur = root;
        while(!sk.isEmpty() || cur != null) {
            while(cur != null) {
                sk.addLast(cur);
                cur = cur.left;
            }
            cur = sk.removeLast();
            if(prev == null) {
                prev = cur.val;
            }else {
                min = Math.min(min, cur.val - prev);
                prev = cur.val;
            }
            cur = cur.right;
        }
        return min;
    }
}