class Solution {
    public int searchInsert(int[] nums, int t) {
        int n = nums.length;
        int i = 0;
        int j = n;
        
        while(i < j) {
            int md = i + ((j - i) >> 1);
            if(nums[md] == t) return md;
            else if(nums[md] > t) j = md;
            else i = md + 1;
        }
        return j;
    }
}