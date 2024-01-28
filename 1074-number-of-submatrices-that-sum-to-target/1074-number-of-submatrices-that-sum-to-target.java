class Solution {
   public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int result = 0;
        for(int i = 0; i < n; i++) { //i is the starting column -> x1
            //for storing sum bw (x2,x1) over cols in rows -> (0,m)
            int[] array = new int[m];
            for(int j = i; j < n; j++) { //j is the ending column -> x2
                for(int k = 0; k < m; k++) {//[k] -> sum bw (x2,x1) over cols, in row -> k
                    array[k] += matrix[k][j];
                }
                //Map-Prefix sum down-words of matrix for(x2,x1)
                result += subarraySum(array, target);
            }
        }
        return result;
    }
    
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}
