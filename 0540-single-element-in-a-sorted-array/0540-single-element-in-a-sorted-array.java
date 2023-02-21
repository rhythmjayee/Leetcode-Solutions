class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        
        while(i <= j) {
            int md = i + ((j - i) >> 1);
            if(md > 0 && nums[md - 1] == nums[md]) {
                if((md - i + 1) % 2 == 0) {
                    i = md + 1;
                }else {
                    j = md - 2;
                }
            }else if(md < n - 1 && nums[md] == nums[md + 1]) {
                if((md - i + 2) % 2 == 0) {
                    i = md + 2;
                }else {
                    j = md - 1;
                }
            }else return nums[md];
        }
        return nums[i];
    }
}