class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int max = Integer.MIN_VALUE;
        while(i < j) {
            int minH = Math.min(nums[j], nums[i]);
            int len = j - i;
            max = Math.max(max, minH*len);
            if(nums[i] <= nums[j]) {
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
}