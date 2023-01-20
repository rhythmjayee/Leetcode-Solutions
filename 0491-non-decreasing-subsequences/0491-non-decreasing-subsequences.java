class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans, new ArrayList<>());
        return ans;
    }
    private void helper(int[] nums, int newStartIndex,  List<List<Integer>> ans, List<Integer> ls) {
        //add all the seq if size > 1
        if(ls.size() > 1) {
            ans.add(new ArrayList<>(ls));
        }
        
        //To avoid using same numbers at same recursion call
        Set<Integer> visitedNow = new HashSet<>();
        for(int k = newStartIndex; k<nums.length; k++) {
            if(visitedNow.contains(nums[k])) continue;
            else if(ls.size() == 0 || ls.get(ls.size() - 1) <= nums[k]) {   
                visitedNow.add(nums[k]);
                ls.add(nums[k]);
                helper(nums, k + 1, ans, ls);
                ls.remove(ls.size() - 1);
            }
        }
    }
}