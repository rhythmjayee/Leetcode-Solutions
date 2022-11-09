class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int x : nums) {
            //replace all odd with 1 & even with 0
            //now calc the no. of subarrays with sum = k
            //use Map + Prefix sum approach
            if(x % 2 != 0) {
                sum += 1;
            }
            //count subarray [0, i]
            if(sum == k) count++;
            //count subaarays [j, i], j = [1, i - 1]
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
/*
 2,2,2,1,2,2,1,2,2,2
 0 0 0 1 1 1 2 2 2 2
*/