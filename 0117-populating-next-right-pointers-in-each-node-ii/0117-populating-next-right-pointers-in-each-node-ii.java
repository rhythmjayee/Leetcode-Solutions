class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return null;
        q.add(root);
        Node prev = null;
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                Node rm = q.poll();
                if(prev != null) {
                    prev.next = rm;
                }
                prev = rm;
                if(rm.left != null) q.add(rm.left);
                if(rm.right != null) q.add(rm.right);
            }
            prev = null;
        }
        return root;
    }
}