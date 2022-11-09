class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        
        while(j < n) {
            nums[i++] = nums[j];
            if(j < n - 1 && nums[j] == nums[j + 1]) {
               nums[i++] = nums[j + 1];
            }
            int val = nums[j];
            while(j < n && val == nums[j]) j++;
        }
        return i;
    }
}