class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int dp[] = new int[nums.length];
        int n = nums.length;
        
        Arrays.sort(nums);
        dp[0] = 1;
        
        int max = 1;
        for(int i = 1; i<n; i++){
            dp[i] = 1;
            for(int j = 0; j<i; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
             max = Math.max(max,dp[i]);
        }
       
        int prev = -1;
        for(int i = n-1; i>=0; i--){
            if(max == dp[i]){
                if(prev == -1 || prev % nums[i] == 0){
                    ls.add(nums[i]);
                    prev = nums[i];
                    max--;
                }
            }
        }
      
      return ls;
    }
}