class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i<=n; i++) {
            g.add(new ArrayList<>());
        }
        for(int[] x : dislikes) {
            g.get(x[0]).add(x[1]);
            g.get(x[1]).add(x[0]);
        }
        
        Integer[] color = new Integer[n+1];
        for(int i = 1; i<=n; i++) {
            if(color[i] == null) {
                color[i] = 1;
                if(!dfs(i, g, color)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int s, List<List<Integer>> g, Integer[] color) {
        for(int x : g.get(s)) {
            if(color[x] != null && color[x] == color[s]) return false;
            else if(color[x] != null) continue;
            color[x] = 1 - color[s];
            if(!dfs(x, g, color)) return false;
        }
        return true;
    }
}