class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int t = 0;
        for(int x : nums) t += x;
        
        int n = nums.length;
        int k = 0;
        int sum = 0;
        int it = (target / t);
        if(target % t == 0) return it * n;
        target %= t;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< 2*n; i++) {
            int idx = (i % n);
            sum += nums[idx];
            if(sum == target) {
                min = Math.min(min, i + 1);
            }
            
            if(map.containsKey(sum - target)) {
                min = Math.min(min, i - map.get(sum - target));
            }
            
            map.put(sum, i);            
        }
        return min == Integer.MAX_VALUE ? -1 : min + it*n;
    }
}


/**

[2,3,5,2,3,4,    4,1,3,    5,2,2,5,1,1,2,5]
2 5 10 12 15 19  23 24 27  32 34 36 37 38 40 45
              0   4. 5  8. 13 15 17 18 19
*/