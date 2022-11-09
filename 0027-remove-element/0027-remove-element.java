class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        int j = 0;
        
        while(j < n) {
            if(nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}