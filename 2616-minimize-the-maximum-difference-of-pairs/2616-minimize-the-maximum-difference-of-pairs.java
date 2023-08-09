class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxDiff = nums[n - 1] - nums[0];
        int i = 0;
        int j = maxDiff;
        int ans = -1;
        while(i <= j) {
            int md = i + ((j - i) >> 1);
            boolean pairsFound = find(nums, md, p);
            if(pairsFound) {
                ans = md;
                j = md - 1;
            } else {
                i = md + 1;
            }
        }
        return ans;
    }
    public boolean find(int[] nums, int minMax, int p) {
        int prev = nums[0];
        int i = 1;
        while(i < nums.length && p > 0) {
            if(nums[i] - prev <= minMax) {
                p--;
                if(i == nums.length - 1) return p == 0;
                prev = nums[i + 1];
                i += 2;
            }else {
                prev = nums[i++];
            }
        }
        return p == 0;
    }
}