class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostKDistinctSubarrays(nums, k) - atmostKDistinctSubarrays(nums, k - 1);
    }
    private int atmostKDistinctSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count = 0;
        int j = 0;
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while(j <= i && map.size() > k) {
                int v = map.get(nums[j]);
                if(v - 1 == 0) {
                    map.remove(nums[j]);
                }else {
                    map.put(nums[j], v - 1);
                }
                j++;
            }
            count += i - j + 1;
        }
        return count;
    }
}