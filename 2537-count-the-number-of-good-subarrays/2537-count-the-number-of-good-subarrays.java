class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        long count = 0;
        int start = 0;
        //counting of pairs logic is important
        for(int end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            //get total pairs
            count += map.get(nums[end]) - 1;
            while(start < end && count >= k) {
                //valid subarry [start, end] found
                //[start, j] , j > end also valid subarray
                ans += nums.length - end;
                map.put(nums[start], map.get(nums[start]) - 1);
                //remove pair formed with start removed element from subarray
                count -= map.get(nums[start]) ;
                start++;
            }
        }
        return ans;
    }
}