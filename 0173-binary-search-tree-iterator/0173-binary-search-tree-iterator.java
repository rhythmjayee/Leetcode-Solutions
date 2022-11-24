class BSTIterator {
    private Deque<TreeNode> sk;
    private boolean addLeft;
    public BSTIterator(TreeNode root) {
        sk = new LinkedList<>();
        addLeft = true;
        addVals(root);
    }
    private void addVals(TreeNode root) {
        while(root != null) {
            sk.addLast(root);
            root = addLeft ? root.left : root.right;
        }
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