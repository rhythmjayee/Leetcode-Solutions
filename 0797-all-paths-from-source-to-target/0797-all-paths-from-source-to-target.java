class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        dfs(0, graph, ans, ls);
        return ans;
    }
    private void dfs(int s, int[][] g, List<List<Integer>> ans, List<Integer> ls) {
        ls.add(s);
        if(s == g.length - 1) {
            ans.add(new ArrayList<>(ls));
            ls.remove(ls.size() - 1);
            return;
        }
        for(int x : g[s]) {
            dfs(x, g, ans, ls);
        }
        ls.remove(ls.size() - 1);
    }
}