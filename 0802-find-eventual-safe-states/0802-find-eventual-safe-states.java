class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> g = new HashMap<>();
        int n = graph.length;
        int[] indegree = new int[n];
        for(int i = 0; i<n; i++) {
            for(int x : graph[i]) {
                g.putIfAbsent(x, new ArrayList<>());
                g.get(x).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++) {
            int x = indegree[i];
            if(x == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
            int rm = q.poll();
            ans.add(rm);
            for(int x : g.getOrDefault(rm, new ArrayList<>())) {
                if(--indegree[x] == 0) q.add(x);
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}