class Solution {
    int count = 0;
    public void preorder(TreeNode node, int path) {
        if (node != null) {
            //even times occured will be off
            path = path ^ (1 << node.val);
            // if it's a leaf check if the path is pseudo-palindromic
            if (node.left == null && node.right == null) {
                // check if at most one digit has an odd frequency
                //1000 & 0111 = 0 =====> 1100 & 1011 != 0
                // x - 1 will off the right most bit and set all the bits in back of rmsb
                if ((path & (path - 1)) == 0) {
                    ++count;
                }
            } else {
                preorder(node.left, path);
                preorder(node.right, path);
            }
        }
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        preorder(root, 0);
        return count;
    }
}