class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for(int x : nums) max = Math.max(max, x);
        
        int start = 0;//left of window
        long count = 0;
        int cur = 0;
        for(int end = 0; end < nums.length; end++) {
            cur += nums[end] == max ? 1 : 0;
            while(cur >= k) {
                //decrement the count till curr has atleast k max nos
                cur -= nums[start++] == max ? 1 : 0;
            }
            //start will be at index where max count < k,
            //index before start will make a subarray
            count += start;//no. of subarrays has alteast k max nos.
        }
        return count;
    }
}