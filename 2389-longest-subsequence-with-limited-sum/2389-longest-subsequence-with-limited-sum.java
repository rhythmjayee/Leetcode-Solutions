class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 1; i<n; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        for(int i = 0; i<m; i++) {
            int x = queries[i];
            int id = find(nums, x);
            ans[i] = id + 1;
        }
        return ans;
    }
    private int find(int[] nums, int x) {
        int i = 0;
        int j = nums.length - 1;
        int idx = -1;
        while(i <= j) {
            int m = ((j - i)>>1) + i;
            if(nums[m] <= x) {
                idx = m;
                i = m + 1;
            }else {
                j = m - 1;
            }
        }
        return idx;
    }
}