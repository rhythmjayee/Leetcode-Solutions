class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        int up = -1;
        for(int i = 0; i < n - 1; i++) {
            if(up == -1 && nums[i] != nums[i + 1]) {
                up = nums[i] > nums[i + 1] ? 1 : 0;
            } 
            else if(up == 1 && nums[i] < nums[i + 1]) return false;
            else if (up == 0 && nums[i] > nums[i + 1]) return false;
        }
        return true;
    }
}