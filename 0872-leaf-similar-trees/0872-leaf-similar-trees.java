class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        String s1 = dfs(root1).toString().trim();
        String s2 = dfs(root2).toString().trim();
        return s1.equals(s2);
    }
    private StringBuilder dfs(TreeNode root) {
        if(root == null) return new StringBuilder();
        else if(root.left == null && root.right == null) return new StringBuilder(root.val+",");
        
        StringBuilder sb = new StringBuilder();
        sb.append(dfs(root.left).toString());
        sb.append(dfs(root.right).toString());
        return sb;
    }
}