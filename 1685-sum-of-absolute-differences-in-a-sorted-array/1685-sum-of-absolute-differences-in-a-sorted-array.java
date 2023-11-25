class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int lSum = 0;
        int[][] numsi = new int[n][2];
        int[] rightSum = new int[n];
        
        for(int i = n - 1; i >= 0; i--) {
            numsi[i][0] = nums[i];
            numsi[i][1] = i;
        }
        Arrays.sort(numsi, (a, b) -> a[0] - b[0]);
        rightSum[n - 1] = numsi[n - 1][0];
        for(int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int restSum = rightSum[i] - numsi[i][0];
            long selfSumLeft = i*numsi[i][0];
            long selfSumRight = (n-i-1)*numsi[i][0];
            long diff = Math.abs(selfSumLeft - lSum) +  Math.abs(selfSumRight - restSum);
            ans[numsi[i][1]] = (int)diff;
            lSum += numsi[i][0];
        }
        return ans;
    }
}