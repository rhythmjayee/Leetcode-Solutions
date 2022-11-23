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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
         List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        int right = 1;
        q.add(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            List<Integer> a = new ArrayList<Integer>();
            while(sz-- > 0) {
                if(right == 1) {
                    TreeNode rm = q.removeFirst();
                    a.add(rm.val);
                    if(rm.left != null) {
                        q.addLast(rm.left);
                    }
                    if(rm.right != null) {
                        q.addLast(rm.right);
                    }
                }else {
                    TreeNode rm = q.removeLast();
                    a.add(rm.val);
                    if(rm.right != null) {
                        q.addFirst(rm.right);
                    }
                    if(rm.left != null) {
                        q.addFirst(rm.left);
                    }
                }
            }
            if(a.size() != 0) ls.add(a);
            right = right == 1 ? 0 : 1;
        }
        return ls;
    }
}