class Solution {
    int ans;
    public int distributeCoins(TreeNode root) {
        distribute(root);
        return ans;
    }
    private int distribute(TreeNode node){
        if(node == null) {
            return 0;
        }
        int left = distribute(node.left);//num of coins from left need to move out/in
        int right = distribute(node.right);//num of coins from right need to move out/in
        ans += Math.abs(left) +Math.abs(right);//mod of sum will be the setps
        
        int coins = left + right;
        if(node.val == 0) coins += -1;
        else coins += node.val-1;
        return coins; 
    }
}