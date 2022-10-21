class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int j = 0; j<n; j++) {
            if(map.containsKey(nums[j])) {
                int i = map.get(nums[j]);
                if(j - i <= k) return true;
            }
            map.put(nums[j], j);
        }
        return false;
    }
}