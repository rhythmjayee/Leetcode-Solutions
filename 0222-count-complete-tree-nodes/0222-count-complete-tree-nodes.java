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
    private Map<TreeNode, Integer> map = new HashMap<>();
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = getHeightLeft(root.left);
        int right = getHeightRight(root.right);

        //If left and right are equal it means that the tree is complete and hence go for 2^h -1.
        if (left == right) return ((2 << (left + 1)) - 1);

        //else recursively calculate the number of nodes in left and right and add 1 for root.
        int nodes = countNodes(root.left) + countNodes(root.right) + 1;
        // System.out.println(root.val+" nodes-> "+nodes);
        return nodes;
    }


    public int getHeightLeft(TreeNode root) { //logh
        if(root == null) return -1;
        else if(map.containsKey(root)) return map.get(root);
         
        int l = getHeightLeft(root.left) + 1;
        map.put(root, l);
        // System.out.println(root.val+" -> "+l);
        return l;
    }


    public int getHeightRight(TreeNode root) {
        if(root == null) return -1;
        else if(map.containsKey(root)) return map.get(root);
         
        int r = getHeightRight(root.right) + 1;
        map.put(root, r);
         // System.out.println(root.val+" -> "+r);
        return r;
    }
}