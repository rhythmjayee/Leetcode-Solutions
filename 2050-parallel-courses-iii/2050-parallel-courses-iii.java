class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] maxTime = new int[n];//per node max time to get processed
        
        for(int[] c : relations) {
            g.computeIfAbsent(c[0] - 1, v -> new ArrayList<>()).add(c[1] - 1);
            indegree[c[1] - 1]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                maxTime[i] = time[i];
            }
        }
        
        int max = 0;
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                int c = q.poll();
                for(int cc : g.getOrDefault(c, new ArrayList<>())) {
                    maxTime[cc] = Math.max(maxTime[cc], maxTime[c] + time[cc]);
                    if(--indegree[cc] == 0) q.add(cc);
                }
            }
        }
        for(int x : maxTime) max = Math.max(max, x);
        return max;
    }
}