class Solution {
    int[] res, count;
    ArrayList<HashSet<Integer>> tree;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N ; ++i)
            tree.add(new HashSet<Integer>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }
//bottom up solution formation for root node
    public void dfs(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            dfs(i, root);
            count[root] += count[i];//stores no of nodes below root node
            res[root] += res[i] + count[i];//res[i] adds ith result and count[i] add additional distance of 1 for each below nodes ---> stores dist from below nodes
        }
        count[root]++;//add root node's count
    }

//top down solution formation for ith node using root node
    public void dfs2(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            //res[root] - count[i] -> remove extra edge from root to every below node's distance
            //count.length - count[i] -> add extra edge from ith node to every node which is not below ith node
            res[i] = res[root] - count[i] + count.length - count[i];
            //root nodes has it final result ->stores result of all child nodes having downwards result
            dfs2(i, root);
        }
    }
}