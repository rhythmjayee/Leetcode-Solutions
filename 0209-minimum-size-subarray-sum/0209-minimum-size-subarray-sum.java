class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int start = 0;
        int n = nums.length;
        int min = n + 1;
        for(int end = 0; end < n; end++) {
            sum += nums[end];
            while(start <= end && sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start++];
            }
        }
        return min == n + 1 ? 0 : min;
    }
}