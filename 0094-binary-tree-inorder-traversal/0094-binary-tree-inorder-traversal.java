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
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> sk = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        TreeNode curr = root;
        
        while(!sk.isEmpty() || curr != null){
            while(curr != null){
                sk.addLast(curr);
                curr = curr.left;
            }
            curr = sk.removeLast();
            ls.add(curr.val);
            curr = curr.right;
        }
        return ls;
    }
}