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
    class BSTIterator {
        private Deque<TreeNode> sk;
            //based on the type of iterator (left, right)
            //left -> add lest most elements first for each root
        private boolean addLeft;
        public BSTIterator(TreeNode root, boolean left) {
            sk = new LinkedList<>();
            addLeft = left;
            addVals(root);
        }
        private void addVals(TreeNode root) {
            while(root != null) {
                sk.addLast(root);
                root = addLeft ? root.left : root.right;
            }
        }
        public int top() {
            return sk.getLast().val;
        }
        public int next() {
            TreeNode root = sk.removeLast();
            //At each pop we try to add left, right elements of poped node
            TreeNode nxt = !addLeft ? root.left : root.right;
            addVals(nxt);

            return root.val;
        }

        public boolean hasNext() {
            return sk.size() != 0;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator lt = new BSTIterator(root, true);
        BSTIterator rt = new BSTIterator(root, false);
        
        while(lt.hasNext() && rt.hasNext()) {
            int l = lt.top();
            int r = rt.top();
            if(l == r) return false;
            int sum = l + r;
            if(sum == k) return true;
            else if(sum > k) rt.next();
            else lt.next();
        }
        return false;
    }
}