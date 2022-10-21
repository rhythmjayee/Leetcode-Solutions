class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        int j = n - 1;
        
        while(i <= j && j >= 0) {
            if(nums[i] == val) {
                swap(nums, i, j);
                j--;
            }else {
                i++;
            }
        }
        return i;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}