class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        int j = n - 1;
        
        while(i <= j && j >= 0) {
            if(nums[i] == val) {
                nums[i] = nums[j--];
            }else {
                i++;
            }
        }
        return i;
    }
}