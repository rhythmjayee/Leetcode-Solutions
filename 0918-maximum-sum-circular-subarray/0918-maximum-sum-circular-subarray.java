class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        /**
        find the maxSum subarray like kadanes
        find the minSum subarray
        find total sum
        ans will be the max (maxSum,(totalSum - minSum))
        */
        
        int maxSum = Integer.MIN_VALUE;
        int tempMaxSum = 0;
        int minSum = Integer.MAX_VALUE;
        int tempMinSum = 0;
        int totalSum = 0;
        
        for(int x : nums){
            totalSum += x;
            
            tempMaxSum += x;
            if(maxSum < tempMaxSum){
                maxSum = tempMaxSum;
            }
            if(tempMaxSum < 0){
                tempMaxSum = 0;
            }
            
            tempMinSum += x;
            if(minSum > tempMinSum){
                minSum = tempMinSum;
            }
            if(tempMinSum > 0){
                tempMinSum = 0;
            }
        }
        //if all nos are negative
        if(minSum == totalSum) return maxSum;
        
        return Math.max(maxSum,totalSum-minSum);
    }
}