class Solution {
    class Node{
        int u;
        int w;
        Node(int u, int w){
            this.u = u;
            this.w = w;
        }
    }
    public int minCostConnectPoints(int[][] p) {
        int n = p.length;
        int sum = 0;
        Map<Integer,Integer> dis = new HashMap<>();//min dist now
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.w-b.w);
        pq.add(new Node(0,0));
        
        while(!pq.isEmpty()){
            Node min = pq.remove();
            int u = min.u;
            
            if(dis.getOrDefault(u,Integer.MAX_VALUE) < min.w) continue;
            
            dis.put(u,min.w);
            sum += min.w;
            
            for(int j = 0; j<n; j++){                
                int d = Math.abs(p[u][0]-p[j][0]) + Math.abs(p[u][1]-p[j][1]);
                
                if(dis.getOrDefault(j,Integer.MAX_VALUE) > d){
                    dis.put(j,d);
                    pq.add(new Node(j,d));
                }
            }
        }
        
        return sum;
    }
}