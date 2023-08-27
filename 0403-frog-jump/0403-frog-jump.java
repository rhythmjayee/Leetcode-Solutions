class Solution {
    HashMap<Integer, Integer> mark = new HashMap<>();
    Integer dp[][] = new Integer[2001][2001];
    
    boolean solve(int[] stones, int n, int index, int prevJump) {
        // If reached the last stone, return 1.
        if (index == n - 1) {
            return true;
        }
        
        // If this subproblem has already been calculated, return it.
        if (dp[index][prevJump] != null) {
            return dp[index][prevJump] == 1;
        }
        
        boolean ans = false;
        // Iterate over the three possibilities {k - 1, k, k + 1}.
        for (int nextJump = prevJump - 1; nextJump <= prevJump + 1; nextJump++) {
            if (nextJump > 0 && mark.containsKey(stones[index] + nextJump)) {
                ans = ans || solve(stones, n, mark.get(stones[index] + nextJump), nextJump);
            }
        }

        // Store the result to fetch later.
        dp[index][prevJump] = (ans ? 1 :0);
        return ans;
    }
    
    public boolean canCross(int[] stones) {
        // Mark stones in the map to identify if such stone exists or not.
        for (int i = 0 ; i < stones.length; i++) {
            mark.put(stones[i], i);
        }
        
        return solve(stones, stones.length, 0, 0);
    }
}