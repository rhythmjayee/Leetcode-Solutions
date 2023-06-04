class Solution {
    private static class UnionFind {
        private int[] id, sz;
        private int nodes;

        public UnionFind(int n) {
            id = new int[n];
            sz = new int[n];
            nodes = n;
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        private int find(int i) {
            if (i == id[i]) return i;
            return id[i] = find(id[i]);
            // Path compression will connect 
            //all the children/descedant node directly connected to top node/parent
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int size(int p) {
            return sz[find(p)];
        }
        public int getNodes() {
            return this.nodes;
        }

        public void union(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (root1 == root2) return; //belongs to same grp
            this.nodes--;
            if (sz[root1] < sz[root2]) { //connect smaller grp to larger
                sz[root2] += sz[root1];
                id[root1] = root2;
            } else {
                sz[root1] += sz[root2];
                id[root2] = root1;
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getNodes();
    }
}