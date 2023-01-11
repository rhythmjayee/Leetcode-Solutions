class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            g.add(new ArrayList<>());
        }
        for(int[] x : edges) {
            g.get(x[0]).add(x[1]);
            g.get(x[1]).add(x[0]);
        }
        
        int steps = dfs(g, 0, -1, hasApple);
        return steps > 0 ? steps: 0;
    }
    private int dfs(List<List<Integer>> g, int node, int parent, List<Boolean> hasApple) {
        int steps = 0;
        for(int x : g.get(node)) {
            if(x == parent) continue;
            int stepsFromChildNode = dfs(g, x, node, hasApple);
            if(stepsFromChildNode >= 0) {
                steps += stepsFromChildNode + 2; //+2 for going & coming
            }
        }
        
        if(steps > 0) return steps;
        return (steps == 0 && hasApple.get(node) ? 0 : -1);
    }
}