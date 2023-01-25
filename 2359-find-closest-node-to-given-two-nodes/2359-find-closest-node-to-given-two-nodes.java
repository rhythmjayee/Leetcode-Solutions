class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        Integer[] n1 = new Integer[n];
        Integer[] n2 = new Integer[n];
        
        dfs(edges, node1, n1, 0, new boolean[n]);
        dfs(edges, node2, n2, 0, new boolean[n]);
        
        int min = Integer.MAX_VALUE;
        int v = -1;
        for(int i = 0; i<n; i++) {
            if(n1[i] == null || n2[i] == null) continue;
            
            int max = Math.max(n1[i], n2[i]);
            if(max < min) {
                min = max;
                v = i;
            }
        }
        return v;
    }
    private void dfs(int[] e, int n, Integer[] d, int dist, boolean[] v) {
        v[n] = true;
        d[n] = dist;
        if(e[n] == -1) return;
        else if(v[e[n]] == false) {
            dfs(e, e[n], d, dist+1, v);
        }else {
            d[e[n]] = Math.min(d[e[n]], dist + 1);
        }
    }
}