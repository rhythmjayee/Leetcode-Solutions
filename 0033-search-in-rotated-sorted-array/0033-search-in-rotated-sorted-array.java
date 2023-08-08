class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        
        while(i <= j) {
            int md = i + ((j - i) >> 1);
            if(nums[md] == target) return md;
            /*
            i  md   j
            1. i <= md -> [i, md] sorted
                1.1 [i t md]
                1.2 [i md t j]
            2. i > md -> [md, j] sorted
                1.1 [md t j]
                1.2 [t md j]
            */
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