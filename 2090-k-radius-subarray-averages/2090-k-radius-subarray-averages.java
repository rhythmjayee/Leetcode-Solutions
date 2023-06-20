class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] sumLeftToRight = new long[n + 1];
        long[] sumRightToLeft = new long[n + 1];
        int[] ans = new int[n];
        
        Arrays.fill(ans, -1);
        if(n < k*2 + 1) return ans;
        
        for(int i = 1; i<=n; i++){
            sumLeftToRight[i] += sumLeftToRight[i - 1]  + nums[i - 1];
        }
        for(int i = n - 1; i >= 0; i--){
            sumRightToLeft[i] += sumRightToLeft[i + 1]  + nums[i];
        }
        
        for(int i = k; i<n-k; i++) {
            long l = sumLeftToRight[i + 1] - sumLeftToRight[i - k];
            long r = sumRightToLeft[i + 1] - sumRightToLeft[i + 1 + k];
            int avg = (int)((l + r) / (2*k + 1));
            ans[i] = avg;
        }
        return ans;
        
    }
}