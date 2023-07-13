class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, List<Integer>> g = new HashMap<>(numCourses);
        int n = numCourses;
        int[] indegree = new int[n];
        
        for(int x[] : prerequisites) {
            g.putIfAbsent(x[0], new ArrayList<>());
            g.putIfAbsent(x[1], new ArrayList<>());
            g.get(x[1]).add(x[0]);
            indegree[x[0]]++;
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
        
        return ans.size() == n;
    }
}