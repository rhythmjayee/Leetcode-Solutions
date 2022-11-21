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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> sk = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        sk.addLast(root);        
        while(!sk.isEmpty()){
            TreeNode rm = sk.removeLast();
            ls.add(rm.val);
            if(rm.right != null)
                sk.addLast(rm.right);
            if(rm.left != null)
                sk.addLast(rm.left);
        }
        return ls;
    }
}