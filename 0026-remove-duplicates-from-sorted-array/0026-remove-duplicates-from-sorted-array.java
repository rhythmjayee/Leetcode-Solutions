class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        
        while(j < n) {
            nums[i++] = nums[j];
            int val = nums[j];
            while(j < n && val == nums[j]) j++;
        }
        return i;
    }
}