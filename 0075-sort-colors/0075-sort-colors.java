class Solution {
    private void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0;//zeros
        int j = 0;//ones -> moving index
        int k = n - 1;//twos
        while(j <= k) {
            if(nums[j] == 0) {
                //ith may be 2 -> which need to process
                //so j will not increment
                swap(nums, i, j);
                i++;
                //ith jth both has one
                if(i > j) j++;
            }else if(nums[j] == 2) {
                //kth may be 0 -> which need to process
                //so j will not increment
                swap(nums, k, j);
                k--;
            }else {
                //jth is one so skip
                j++;
            }
        }
    }
}