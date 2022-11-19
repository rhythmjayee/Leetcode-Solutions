class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int lo = 0;//min diff bw 2 nos.
        int hi = nums[nums.length - 1] - nums[0];//max diff bw 2 nos.
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            //check no. of diff which is <= mi
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mi) left++;
                count += right - left;
            }
            //count = number of pairs with distance <= mi
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
}