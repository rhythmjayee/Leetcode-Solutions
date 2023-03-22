class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] g = new ArrayList[n + 1];
        for(int i = 1; i<=n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int x[] : roads) {
            int u = x[0];
            int v = x[1];
            int w = x[2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }
        
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        
        while(!q.isEmpty()) {
            int[] r = q.poll();
            int v = r[0];
            int w = r[1];
            for(int[] x : g[v]) {
                if(x[1] < d[x[0]]) {
                    d[x[0]] = x[1];
                    q.add(x);
                }
            }
        }
        //As we can go to the min path and come back to same path
        //which may be connected to nth node
        int min = Integer.MAX_VALUE;
        for(int x : d) {
            min = Math.min(min, x);
        }
        return min;
    }
}