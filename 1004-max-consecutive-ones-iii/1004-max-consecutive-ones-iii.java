class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zeros = 0;
        int max = Integer.MIN_VALUE;
        int j = 0;
        for(int i = 0; i < n; i++) {
            //inc zeros
            if(nums[i] == 0) zeros++;
            //make the zeros till k
            while(j <= i && zeros > k) {
                    if(nums[j++] == 0) zeros--;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}