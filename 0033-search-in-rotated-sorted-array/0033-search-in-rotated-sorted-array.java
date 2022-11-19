class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        
        while(i <= j) {
            int md = i + ((j - i) >> 1);
            if(nums[md] == target) return md;
            else if(nums[md] >= nums[i]) {
                if(nums[md] > target && nums[i] <= target) {
                    j = md - 1;
                }else {
                    i = md + 1;
                }
            }else {
                if(nums[md] < target && nums[j] >= target) {
                    i = md + 1;
                }else {
                    j = md - 1;
                }
            }
        }
        return -1;
    }
}