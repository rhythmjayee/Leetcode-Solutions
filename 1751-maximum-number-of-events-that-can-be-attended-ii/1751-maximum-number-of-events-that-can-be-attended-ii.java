class Solution {
    private Integer[][] dp;
    private int[] nextIndices;
    
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        nextIndices = new int[n];
        //cache the next event index w.r.t each event's end time
        for (int curIndex = 0; curIndex < n; ++curIndex) {
            nextIndices[curIndex] = bisectRight(events, events[curIndex][1]);
        }
        
        dp = new Integer[k + 1][n];
        
        return dfs(0, k, events);
    } 
    
    private int dfs(int curIndex, int count, int[][] events) {
        if (count == 0 || curIndex == events.length) {
            return 0;
        }
        if (dp[count][curIndex] != null) {
            return dp[count][curIndex];
        }
        int nextIndex = nextIndices[curIndex];
        dp[count][curIndex] = Math.max(dfs(curIndex + 1, count, events), events[curIndex][2] + dfs(nextIndex, count - 1, events));
        return dp[count][curIndex];
    }
    
    public static int bisectRight(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = left + ((right -  left) >> 1);
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }   
}