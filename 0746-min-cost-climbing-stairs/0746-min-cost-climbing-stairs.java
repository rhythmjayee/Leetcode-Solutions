class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int one = cost[0];
        int two = cost[1];
        
        for(int i = 2; i < n; i++) {
            int t = Math.min(one, two) + cost[i];
            one = two;
            two = t;
        }
        return Math.min(one, two);
    }
}