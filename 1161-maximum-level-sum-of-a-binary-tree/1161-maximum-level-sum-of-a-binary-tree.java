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
    public int maxLevelSum(TreeNode root) {
        long max = Long.MIN_VALUE;
        int lvl = -1;
        int currLvl = 0;
        Deque<TreeNode> ll = new LinkedList<>();
        ll.addFirst(root);
        
        while(!ll.isEmpty()) {
            int sz = ll.size();
            long sum = 0;
            currLvl++;
            while(sz-- > 0) {
                TreeNode rm = ll.removeLast();
                sum += rm.val;
                if(rm.left != null) {
                     ll.addFirst(rm.left);
                }
                if(rm.right != null) {
                     ll.addFirst(rm.right);
                }
            }
            if(sum > max) {
                max = sum;
                lvl = currLvl;
            }
        }
        return lvl;
    }
}