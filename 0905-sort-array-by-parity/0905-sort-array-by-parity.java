class Solution {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        
        while(i < j) {
            if((nums[i] & 1) != 0) {//odd on i
                swap(nums, i, j--);
            } else if((nums[j] & 1) == 0) {//even on j
                swap(nums, i++, j);
            } else {
                i++;
            }
        }
        return nums;
    }
}
/*
[3,1,2,4]
[4 1 2 3]
[4 2 1 3]
*/