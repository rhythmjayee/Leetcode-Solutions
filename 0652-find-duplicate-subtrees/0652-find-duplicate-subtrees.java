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
    Map<String, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        preorder(root);
        for(String k : map.keySet()) {
            if(map.get(k).size() > 1) {
                res.add(map.get(k).get(0));
            }
        }
        return res;
    }
    public StringBuilder preorder(TreeNode root) {
        if(root == null) return new StringBuilder("#");
        StringBuilder l = preorder(root.left);
        StringBuilder r = preorder(root.right);
        
        StringBuilder nodePreOrder = new StringBuilder(root.val+"$");
        nodePreOrder.append(l);
        nodePreOrder.append(r);
        String res = nodePreOrder.toString();
        // System.out.println(res);
        map.putIfAbsent(res, new ArrayList<>());
        map.get(res).add(root);
        
        return nodePreOrder;
    }
}