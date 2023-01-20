class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        helper(nums, 0, -1, ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }
    private void helper(int[] nums, int newStartIndex, int prevIndex,  Set<List<Integer>> ans, List<Integer> ls) {
        if(ls.size() >= 2 && newStartIndex == nums.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }else if(newStartIndex == nums.length) return;
        
        for(int k = newStartIndex; k<nums.length; k++) {
            if(prevIndex == -1 || nums[prevIndex] <= nums[k]) {                
                ls.add(nums[k]);
                helper(nums, k + 1, k, ans, ls);
                ls.remove(ls.size() - 1);
            }
            
            helper(nums, k + 1, prevIndex, ans, ls);
        }
        
    }
}