class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer> emp[] = new ArrayList[n];
        for(int i = 0; i<n; i++) {
            if(manager[i] == -1) continue;
            else if(emp[manager[i]] == null) emp[manager[i]] = new ArrayList<>();
            emp[manager[i]].add(i);
        }
        
        return dfs(headID, emp, informTime);
    }
    public int dfs(int u, List<Integer> emp[], int[] informTime) {
        if(emp[u] == null) return 0;
        int time = informTime[u];
        int res = 0;
        for(int e : emp[u]) {
            res = Math.max(res, dfs(e, emp, informTime));
        }
        return res + time;
    }
}