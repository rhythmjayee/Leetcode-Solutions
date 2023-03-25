class Solution {
    public long countPairs(int n, int[][] edges) {
        DisjointSet dsu = new DisjointSet(n);
        for(int[] e : edges) {
            dsu.union(e[0], e[1]);
        }

        if(dsu.getComponents() == 1) return 0;
        
        long pairs = 0;
        long remainingNodes = n;
        Set<Integer> parents = new HashSet<>();
        for (int i = 0; i<n; i++) {
            int p = dsu.find(i);
            if(parents.contains(p)) continue;
            parents.add(p);
            pairs += dsu.getSize(p) * (remainingNodes - dsu.getSize(p));
            remainingNodes -= dsu.getSize(p);
        }
        return pairs;
    }
}
class DisjointSet {
    private int[] parent;
    private int[] size;
    private int components;
    DisjointSet(int n) {
        this.components = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i<n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int getComponents() {
        return components;
    }
    public int getParent(int x) {
        return parent[x];
    }
    public int getSize(int x) {
        return size[x];
    }
    public int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);
        if(p1 != p2) {
            components--;
            if(size[p2] >= size[p1]) {
                parent[p1] = p2;
                size[p2] += size[p1];
            }else {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
        }
    }
}