class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        long pd = 1L;
        int count = 0;
        for(int end = 0; end < n; end++) {
            pd *= nums[end];
            while(start <= end && pd >= k) {
                pd /= nums[start++];
            }
            count += (end - start + 1);
        }
        return count;
    }
}
/*
nums = [10,5,2,6], k = 100
(10)
(10, 5) (5)
(5, 2) (2)
(5, 2, 6) (2, 6) (6)

*/