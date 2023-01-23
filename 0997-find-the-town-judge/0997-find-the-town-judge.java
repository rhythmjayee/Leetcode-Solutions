class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] t = new int[n + 1];
        for(int[] x : trust) {
            t[x[1]]++;
            t[x[0]]--;
        }
        for(int i = 1; i<=n; i++) {
            if(t[i] == n - 1) return i;
        }
        return -1;
    }
}