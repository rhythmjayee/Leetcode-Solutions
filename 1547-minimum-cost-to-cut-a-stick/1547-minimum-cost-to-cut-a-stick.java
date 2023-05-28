class Solution {
    Integer[][] memo;
    int newCuts[];
    private int cost(int left, int right) {
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        if (right - left == 1) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int mid = left + 1; mid < right; mid++) {
            int cost = cost(left, mid) + cost(mid, right) + newCuts[right] - newCuts[left];
            ans = Math.min(ans, cost);
        }
        memo[left][right] = ans;
        return ans;
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        newCuts = new int[m + 2];
        //copy the cuts postion as [0,[cuts],n]
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        Arrays.sort(newCuts);
        
        memo = new Integer[m + 2][m + 2];
        return cost(0, newCuts.length - 1);
    }    
}