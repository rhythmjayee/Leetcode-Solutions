class Solution {
    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];//i+j
        arr[j] = arr[i] - arr[j];//i+j - j = i
        arr[i] = arr[i] - arr[j];//i+j - i = j
    }
    public int findDuplicate(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n) {
            while(nums[i] - 1 != i) {
                if(nums[nums[i] - 1] == nums[i]) return nums[i];
                swap(nums, nums[i] - 1, i);
            }
            i++;
        }
        return -1;
    }
}