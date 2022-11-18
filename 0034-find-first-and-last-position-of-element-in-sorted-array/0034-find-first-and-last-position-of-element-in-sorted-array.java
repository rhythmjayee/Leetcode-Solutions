class Solution {
    static enum Position{
        FIRST, LAST;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if(nums.length  == 0) return ans;
        ans[0]  = find(nums, target, Position.FIRST);
        if(ans[0] == -1) return ans;
        ans[1] = find(nums, target, Position.LAST);
        
        return ans;
    }
    private int find(int[] nums, int t, Position isLast) {
        int i = 0; 
        int n = nums.length;
        int j = n - 1;
        int pos = -1;
        while(i <= j) {
            int md = i + ((j - i) >> 1);
            if(nums[md] == t) pos = md;
            
            if(isLast == Position.FIRST) {
                if(nums[md] >= t) {
                    j = md - 1;
                }else {
                    i = md + 1;
                }
            }else {
                if(nums[md] <= t) {
                    i = md + 1;
                }else {
                    j = md - 1;
                }
            }
        }
        
        return pos;
    }
}