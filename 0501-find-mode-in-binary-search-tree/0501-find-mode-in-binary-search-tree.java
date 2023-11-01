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
    private List<Integer> inOrder(TreeNode root) {
        Deque<TreeNode> sk = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        Integer prev = null;
        int currCount = 0;
        int max = 0;
        
        TreeNode cur = root;
        while(cur != null || !sk.isEmpty()) {
            while(cur != null) {
                sk.addLast(cur);
                cur = cur.left;
            }
            cur = sk.removeLast();
            if(prev != null && prev == cur.val) {
                currCount++;
            } else {
                if(max <= currCount) {
                    while(currCount > max && ls.size() > 0) {
                        ls.remove(ls.size() - 1);
                    }
                    max = Math.max(max, currCount);
                    if(prev != null) ls.add(prev);
                }
                currCount = 1;
            }
            prev = cur.val;
            cur = cur.right;
        }
        if(max <= currCount) {
            while(currCount > max && ls.size() > 0) {
                ls.remove(ls.size() - 1);
            }
            max = Math.max(max, currCount);
            if(prev != null) ls.add(prev);
        }
        return ls;
    }
    public int[] findMode(TreeNode root) {
        List<Integer> ls = inOrder(root);
        int[] ans = ls.stream().mapToInt(x -> x).toArray();
        return ans;
    }
}