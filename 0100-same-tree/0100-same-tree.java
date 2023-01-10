
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
         Queue<TreeNode> qq = new LinkedList<>();
            qq.add(p);
            qq.add(q);
        while (!qq.isEmpty()) {
            TreeNode t1 = qq.poll();
            TreeNode t2 = qq.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            qq.add(t1.left);
            qq.add(t2.left);
            qq.add(t1.right);
            qq.add(t2.right);
        }
        
        return true;
    }
}