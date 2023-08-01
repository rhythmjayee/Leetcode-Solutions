class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>());
        return ans;
    }
    public void dfs(int index, int n, int k, List<Integer> comb) {
        if(k == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for(int i = index; i<=n; i++) {
            comb.add(i);
            dfs(i + 1, n, k - 1, comb);
            comb.remove(comb.size() - 1);
        }
    }
}