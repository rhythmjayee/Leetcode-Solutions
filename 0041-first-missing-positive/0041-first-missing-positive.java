class Solution {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;
        
        while(i < n) {
            while(nums[i] > 0 && nums[i] <= n 
                  && nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            i++;
        }
        
        for(i = 0; i < n; i++) {
            if(nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}