/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private void dfs(Node node,  Map<Integer, Node> map) {
        for(Node ch : node.neighbors) {
            if(!map.containsKey(ch.val)) {
                map.put(ch.val, new Node(ch.val));
                dfs(ch, map);
            }
            map.get(node.val).neighbors.add(map.get(ch.val));
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Node n = new Node(node.val);
        map.put(node.val, n);
        
        dfs(node, map);
        return n;
    }
}