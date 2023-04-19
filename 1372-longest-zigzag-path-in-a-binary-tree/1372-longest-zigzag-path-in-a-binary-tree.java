class Solution {
    int pathLength = 0;
    private void dfs(TreeNode root, int left, int right) {
        if (root != null) {
            pathLength = Math.max(pathLength, Math.max(left, right));
            //go left -> take right dist or if need go left then dist = 0
            dfs(root.left, right + 1, 0);
            //go right -> take left dist or if need go right again then dist = 0
            dfs(root.right, 0, left + 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        //root, left, right distance seen till now
        dfs(root, 0, 0);
        return pathLength;
    }
}