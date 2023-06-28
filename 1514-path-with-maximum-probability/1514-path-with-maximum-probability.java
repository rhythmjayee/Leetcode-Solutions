class Solution {
    class Edge{
        int v;
        double p;
        Edge(int v,double p){
            this.v = v;
            this.p = p;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,List<Edge>> g = new HashMap<>();
        for(int i = 0; i<n; i++){
            g.put(i,new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            int[] e = edges[i];
            double pb = succProb[i];
            g.get(e[0]).add(new Edge(e[1],pb));
            g.get(e[1]).add(new Edge(e[0],pb));
        }
        double pb[] = new double[n];
        int[] vis = new int[n];
        pb[start] = 1.0;
        vis[start] = 1;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->{
            return Double.compare(b.p,a.p);
        });
        pq.add(new Edge(start,1.0));
        
        while(!pq.isEmpty()){
            Edge rm = pq.remove();
            
            int u = rm.v;
            double p = rm.p;
            
            vis[u] = 1;
            if(u == end) return p;
            
            for(Edge v: g.get(u)){
                if(vis[v.v] == 0 && pb[v.v] <= pb[u] * v.p){
                    pb[v.v] = pb[u] * v.p;
                    pq.add(new Edge(v.v,pb[v.v]));
                }
            }
        }
        
        return 0.0;
    }
}