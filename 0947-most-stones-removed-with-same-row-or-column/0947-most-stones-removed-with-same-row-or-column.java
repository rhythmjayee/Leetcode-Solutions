class Solution {
    public int removeStones(int[][] stones) {
        if(stones.length == 1) return 0;
      
        int n = stones.length;
      
        int[] parent = new int[20000];
        int[] size = new int[20000];
        for (int i = 0; i < 20000; i++) {
            parent[i] = i;
            size[i] = 1;
        }
          Set<Integer> parentNodes = new HashSet<>();

          for (int[] c : stones) {
                //connect x, y under same parent
                int p1 = findParent(parent, c[0]);//x
                int p2 = findParent(parent, c[1]+10000);//y
                if (p1 != p2) {
                    if (size[p1] < size[p2]) { // Merge small size to large size
                        size[p2] += size[p1];
                        parent[p1] = p2;//p2 larger
                      if(!parentNodes.contains(p2)) parentNodes.add(p2);
                        //if p2 doesnt exist as parentNode
                      if(parentNodes.contains(p1)) parentNodes.remove(p1);
                        //if p1 exist as parentNode remove
                    } else {
                        size[p1] += size[p2];
                        parent[p2] = p1;//p1 larger
                      if(!parentNodes.contains(p1)) parentNodes.add(p1);
                      if(parentNodes.contains(p2)) parentNodes.remove(p2);
                    }

                }
            }

          return n-parentNodes.size();
                    
    }
    
        private int findParent(int[] parent, int i) {
            if (i == parent[i]) return i;
            return parent[i] = findParent(parent, parent[i]); // Path compression this will connect 
                                                            //all the children/descedant node directly connected to top node/parent
        }
}