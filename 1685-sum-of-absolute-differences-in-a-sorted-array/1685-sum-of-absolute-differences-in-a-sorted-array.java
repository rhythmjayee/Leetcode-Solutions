class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int lSum = 0;
        
        int totalSum = 0;
        for(int x : nums) totalSum += x;
        
        /**
        If array is not sorted, below steps is required as
        we want element on left side smaller so that we have +ve diff
        and elements on right are larger so more -ve diff on right
        
        int[][] numsi = new int[n][2];
        for(int i = n - 1; i >= 0; i--) {
            numsi[i][0] = nums[i];
            numsi[i][1] = i;
        }
        Arrays.sort(numsi, (a, b) -> a[0] - b[0]);
        ***/

        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int restSum = totalSum - nums[i] - lSum;
            long selfSumLeft = i*nums[i];
            long selfSumRight = (n-i-1)*nums[i];
            long diff = Math.abs(selfSumLeft - lSum) +  Math.abs(selfSumRight - restSum);
            ans[i] = (int)diff;
            lSum += nums[i];
        }
        return ans;
    }
}