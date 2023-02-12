class Solution {
    long fuel;
    public long dfs(int node, int parent, Map<Integer, List<Integer>> adj, int seats) {
        // The node itself has one representative.
        int representatives = 1;
        if (!adj.containsKey(node)) {
            return representatives;
        }
        for (int child : adj.get(node)) {
            if (child != parent) {
                // Add count of representatives in each child subtree to the parent subtree.
                representatives += dfs(child, node, adj, seats);
            }
        }
        if (node != 0) {
            // Count the fuel it takes to move to the parent node.
            // Root node does not have any parent so we ignore it.
            fuel += Math.ceil((double) representatives / seats);
        }
        return representatives;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int[] r : roads) {
            g.putIfAbsent(r[0], new ArrayList<>());
            g.putIfAbsent(r[1], new ArrayList<>());
            g.get(r[0]).add(r[1]);
            g.get(r[1]).add(r[0]);
        }
        dfs( 0, -1, g, seats);
        return fuel;
    }
}