class Solution {
    class Node{
        int node;
        int dist;
        int mask;
        Node(int n, int d, int m){
            node = n;
            dist = d;
            mask = m;
        }
    }
    public int shortestPathLength(int[][] graph) {
        return bfs(graph);
    }
    public int bfs(int[][] g){
        int n = g.length;
        if(n == 1) return 0;
        int all = (1 << n) - 1;//mask with all bits on
        
        Queue<Node> q = new LinkedList<>();//{node,{dist,mask}}
        Set<String> set = new HashSet<>();//node+mask
        
        for(int i = 0; i<n; i++){
            int mask = (1<<i);
            q.add(new Node(i,0,mask));
            set.add(i+""+mask);
        }
        
        while(!q.isEmpty()){
            Node rm = q.poll();
            int node = rm.node;
            int dist = rm.dist;
            int mask = rm.mask;
            
            for(int x : g[node]){
                int newMask = (mask | (1<<x));
                String hash = x+""+newMask;
                if(newMask == all) return dist+1;
                else if(set.contains(hash)) continue;
                
                q.add(new Node(x,dist+1,newMask));
                set.add(hash);
            }
            
        }
        return 0;
    }
}