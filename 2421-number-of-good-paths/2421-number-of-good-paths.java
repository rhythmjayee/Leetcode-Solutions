class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int N = vals.length;
        ArrayList<Integer>[] adj = new ArrayList[N];
        TreeMap<Integer, ArrayList<Integer>> sameValues = new TreeMap<>();
        int result = 0;

        for(int i=0; i<N; i++) {
            //forming a adjcent list
            adj[i] = new ArrayList<>();
            //adding same values node in single list of TreeMap
            if(!sameValues.containsKey(vals[i])) sameValues.put(vals[i], new ArrayList<>());
            sameValues.get(vals[i]).add(i);
        }

        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            //connecting nodes with children with <= vals
            //so that nodes with same value have node with <= val bw them
            if(vals[u] >= vals[v]) {
                adj[u].add(v);
            } else {
                adj[v].add(u);
            }
        }

        UF uf = new UF(N);
        //traverse the sorted values of nodes
        for (int val : sameValues.keySet()) {
            List<Integer> nodes = sameValues.get(val);
            //connect nodes with their adj nodes
            //and adj nodes having val <= node's value
            for (int node : nodes) {
                for (int ad : adj[node]) {
                    uf.union(node, ad);
                }
            }

            // count the connected components
            Map<Integer, Integer> componentCount = new HashMap<>();
            for (int node: nodes) {
                int root = uf.find(node);
                componentCount.put(root, componentCount.getOrDefault(root, 0) + 1);
            }
            
            //total nodes with same value -> as they will be forming good paths
            int total = nodes.size();
            for (int component : componentCount.keySet()) {
                int count = componentCount.get(component);
                //count of paths from components with end nodes has same value
                total += count * (count - 1) / 2;
            }
            result += total;
        }
    
    return result;
    
}

class UF {

    int[] parent;

    public UF(int len) {
        parent = new int[len];
        Arrays.fill(parent, -1);
    }

    public int find(int a) {
        if(parent[a] >= 0) {
            return parent[a] = find(parent[a]);    
        }
        return a;
    }

    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return false;

        if(parent[pa] <= parent[pb]) {
            parent[pa] += parent[pb];
            parent[pb] = pa;
        } else {
            parent[pb] += parent[pa];
            parent[pa] = pb;
        }
        
        return true;
    }
}
    
}