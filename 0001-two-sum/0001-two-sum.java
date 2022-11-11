class Solution {
    public int[] twoSum(int[] nums, int t) {
        //a+b = t
        //a = t-b
        //b = t-a
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(t - nums[i])) {
                return new int[]{map.get(t - nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}