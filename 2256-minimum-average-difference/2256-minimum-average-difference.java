class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        
        for(int i = n - 1; i >= 0; i--) {
            sum += nums[i];
        }
        long min = Long.MAX_VALUE;
        int dx = -1;
        long s = 0;
        for(int i = 0; i < n; i++) {
            s += nums[i];
            long avg1 = Math.round(s / (i + 1));
            long avg2 = i == n - 1 ? 0 : Math.round((sum - s) / (n - i - 1));
            long diff = Math.abs(avg1 - avg2);
            
            if(diff < min) {
                min = diff;
                dx = i;
            }
        }
        return dx;
    }
}