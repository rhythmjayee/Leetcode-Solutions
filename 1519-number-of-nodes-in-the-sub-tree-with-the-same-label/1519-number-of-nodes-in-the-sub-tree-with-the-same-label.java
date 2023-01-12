class Solution {
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] ans = new int[n];
        int[][] count = new int[n][26];
        
        char[] lab = labels.toCharArray();
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] e : edges){
            map.putIfAbsent(e[0],new ArrayList<>());
            map.putIfAbsent(e[1],new ArrayList<>());
            
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        get(map,0,count,lab,new int[n]);
        
        for(int i = 0; i<n;i++){
            char c = lab[i];
            ans[i] = count[i][c-'a'];
        }
        
        return ans;
    }
    
    public void get(Map<Integer,List<Integer>> map,int root,int[][] count,char[] lab,int[] v){
        v[root] = 1;
        char c = lab[root];
        
        for(int x : map.get(root)){
            if(v[x] == 0){
                get(map,x,count,lab,v);
                
                for(int i = 0; i<26;i++)
                    count[root][i] += count[x][i];
            }
        }
        count[root][c-'a']++;
    }
}