class Solution {
    public int minOperations(int[] nums, int x) {
        
        int target = -x;//sum from left+right ends of array
        for (int num : nums) target += num;//sum-x, subarray of sum is need to find
        // since all elements are positive, we have to take all of them
        if (target == 0) return nums.length;

        //longest subarray sum find technique  
        //-> because min elements need to take from left, right
        int n = nums.length;
        int sum = 0;
        int start = 0;
        int len = Integer.MIN_VALUE;//max len of subarray with sum target
        for(int end = 0; end<n; end++){
            sum += nums[end];
            
            while(start < end && sum > target){
                sum -= nums[start++];
            }
            if(sum == target){
                len = Math.max(len,end-start+1);
            }
        }
        
        return len == Integer.MIN_VALUE ? -1 : n - len;
    }
}