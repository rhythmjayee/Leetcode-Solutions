class Solution {
    private List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    public void dfs(int[] nums, int vistedMask, List<Integer> per) {
        if(vistedMask == (1 << nums.length) - 1) {
            ans.add(new ArrayList<>(per));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if((vistedMask & (1 << i)) != 0) continue;
            vistedMask  = vistedMask |  (1 << i);
            per.add(nums[i]);
            dfs(nums, vistedMask, per);
            per.remove(per.size() - 1);
            vistedMask  = vistedMask &  (~(1 << i));
        }
    }
}