class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return ans;
    }
    private void helper(int[] nums, int index, List<Integer> ls) {
        if (index > nums.length - 1) {
            if (ls.size() > 1) ans.add(new ArrayList<>(ls));
            return;
        } 
        
        if (ls.isEmpty() || nums[index] >= ls.get(ls.size() - 1)) {
            ls.add(nums[index]);
            helper(nums, index + 1, ls);
            ls.remove(ls.size() - 1);
        }
        
        // repeated value, so don't need to drill down.
        if (index > 0 
            && ls.size() > 0 
            && nums[index] == ls.get(ls.size() - 1)) {
            return;
        }
        helper(nums, index + 1, ls);
    }
}