class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        Integer color[] = new Integer[n];
        
        for(int i =0; i<n; i++){
            if(color[i] == null){
                color[i] = 1;
                if(!dfs(graph,i,color)) return false; 
            }     
        }
        
        return true;
    }
    public boolean dfs(int[][] g, int i, Integer[] c){
        
        for(int x : g[i]){
            if(c[x] == null){
                c[x] = 1 - c[i];
                if(!dfs(g,x,c)) return false;
            } 
            else if(c[i] == c[x]) return false;
        }
        
        return true;
    }
}