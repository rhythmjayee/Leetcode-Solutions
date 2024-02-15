class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] presum = new long[n];
        presum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            presum[i] = nums[i] + presum[i - 1];
        }
        for(int i = n - 1; i >= 2; i--) {
            if(nums[i] < presum[i - 1]) return presum[i];
        }
        return -1;
    }
}