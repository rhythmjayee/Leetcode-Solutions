class UnionFind {
    private int[] id, sz;
    public int n;

    public UnionFind(int n) {
      this.n = n;
      id = new int[n + 1];
      sz = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        id[i] = i;
        sz[i] = 1;
      }
    }

    private int find(int i) {
        if (i == id[i]) return i;
        return id[i] = find(id[i]);
    }

    public boolean connected(int p, int q) {
      return find(p) == find(q);
    }

    public boolean union(int p, int q) {
      int root1 = find(p);
      int root2 = find(q);
      if (root1 == root2) {
          return false;//belongs to same grp
      }
        
      this.n -= 1;
      if (sz[root1] < sz[root2]) {//connect smaller grp to larger
        sz[root2] += sz[root1];
        id[root1] = root2;
      } else {
        sz[root1] += sz[root2];
        id[root2] = root1;
      }
     return true;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        UnionFind uf1 = new UnionFind(n);
        UnionFind uf2 = new UnionFind(n);
        
        int rm3 = 0;
        int rm1 = 0;
        int rm2 = 0;
        
        for(int[] x : edges) {
            if(x[0] == 3) {
                boolean r1 = uf1.union(x[1], x[2]);
                boolean r2 = uf2.union(x[1], x[2]);
                if(!r1 && !r2) {
                    rm3++;
                }
            }else if(x[0] == 1) {
                boolean r1 = uf1.union(x[1], x[2]);
                rm1 += r1 ? 0 : 1;
            }else if(x[0] == 2) {
                boolean r2 = uf2.union(x[1], x[2]);
                 rm2 += r2 ? 0 : 1;
            }
            // System.out.println(x[0] +" "+x[1]+" "+x[2]+" "+uf1.n+" "+uf2.n+" -> "+rm1+" "+rm2+" "+rm3);
        }
        return (uf1.n != 1 || uf2.n != 1 ) ? -1 : (rm1 + rm2 + rm3);
    }
}