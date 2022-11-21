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
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> sk = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        TreeNode curr = root;
        TreeNode prev = null;
        
        while(!sk.isEmpty() || curr != null){
            while(curr != null){
                sk.addLast(curr);
                curr = curr.left;
            }
            curr = sk.getLast();
            if(curr.right != null && prev != curr.right) {
                curr = curr.right;
            }else {
                curr = sk.removeLast();
                ls.add(curr.val);
                prev = curr;
                curr = null;
            }
        }
        return ls;
    }
}