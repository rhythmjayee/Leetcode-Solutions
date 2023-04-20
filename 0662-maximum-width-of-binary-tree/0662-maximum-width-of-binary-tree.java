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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        int max = 1;
        q.add(new Pair(root,1));
       
        while(!q.isEmpty()){
            int s = q.size();
            int st = q.peek().getValue();
             Pair<TreeNode,Integer> curr = null;
            while(s-- >0){
                curr = q.poll();
                TreeNode node = curr.getKey();
                if(node.left!=null){
                    q.add(new Pair(node.left,2*curr.getValue()));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right,2*curr.getValue()+1));
                }
            }
            max = Math.max(max,curr.getValue()-st +1);
        }
        return max;
    }
}