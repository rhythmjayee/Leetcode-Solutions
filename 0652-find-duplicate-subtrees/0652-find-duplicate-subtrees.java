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
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ls = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        preorder(root);
        return ls;
    }
    public StringBuilder preorder(TreeNode root) {
        if(root == null) return new StringBuilder("#");
        StringBuilder l = preorder(root.left);
        StringBuilder r = preorder(root.right);
        
        StringBuilder nodePreOrder = new StringBuilder(root.val+"$");
        nodePreOrder.append(l);
        nodePreOrder.append(r);
        String res = nodePreOrder.toString();
        
        map.put(res, map.getOrDefault(res, 0) + 1);
        if(map.get(res) == 2) {
            ls.add(root);
        }        
        return nodePreOrder;
    }
}