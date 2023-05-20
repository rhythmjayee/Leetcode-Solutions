class Solution {
    public static class Edge {
        String v;
        double w;
        public Edge(String v, double w) {
            this.v = v;
            this.w = w;
        }
    }
    public double dfs(Map<String, List<Edge>> g, String s, String e, Set<String> seen) {
        if (!g.containsKey(s)) {
            return -1.0;
        } else if(s.equals(e)) {
            return 1.0;
        }
        seen.add(s);
        for(Edge eg : g.get(s)) {
            if(!seen.contains(eg.v)) {
                double res = dfs(g, eg.v, e, seen);
                if(res != -1.0) {
                    return res * eg.w;
                }
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> g = new HashMap<>();
        double[] ans = new double[queries.size()];
        
        for(int i = 0; i < values.length; i++) {
            List<String> vars = equations.get(i);
            g.putIfAbsent(vars.get(0), new ArrayList<>());
            g.putIfAbsent(vars.get(1), new ArrayList<>());
            g.get(vars.get(0)).add(new Edge(vars.get(1), values[i]));
            g.get(vars.get(1)).add(new Edge(vars.get(0), 1.0/values[i]));
        }
        
        for(int i = 0; i < queries.size(); i++) {
            Set<String> seen = new HashSet<>();
            double val = dfs(g, queries.get(i).get(0), queries.get(i).get(1), seen);
            ans[i] = val;
        }
        return ans;
    }
}