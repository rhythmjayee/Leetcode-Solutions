class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            g.add(new ArrayList<>());
        }
        for(int[] x : edges) {
            g.get(x[0]).add(x[1]);
            g.get(x[1]).add(x[0]);
        }
        return dfs(g, s, d, new int[n]);
    }
    private boolean dfs(List<List<Integer>> g, int s, int d, int[] v) {
        if(s == d) return true;
        v[s] = 1;
        for(int x : g.get(s)) {
            if(v[x] == 0) {
                if(x == d) return true;
                else if(dfs(g, x, d, v)) return true;
            }
        }
        return false;
    }
}