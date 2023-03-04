class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int indexOutOfBound = -1;//most recent
        int indexMaxK = -1;//most recent
        int indexMinK = -1;//most recent
        long ans = 0;
        
        //Adding by finding number of subarray at ending ith index
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK) indexOutOfBound = i;
            if(nums[i] == minK) indexMinK = i;
            if(nums[i] == maxK) indexMaxK = i;
            
            int validRecentSubarrayStart = Math.min(indexMinK, indexMaxK);
            //must be on left of validRecentSubarrayStart for valid subarray
            ans += Math.max(0, validRecentSubarrayStart - indexOutOfBound);
        }
        return ans;
    }
}