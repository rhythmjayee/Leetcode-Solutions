class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int start = 0;
        int zero = 0;
        int lastConvertedZro = 0;
        for(int end = 0; end < n; end++) {
            int x = nums[end];
            if(x == 1 || zero == 0) {
                if(x != 1 && zero == 0) {
                    zero = 1;
                    lastConvertedZro = end;
                }
            } else {
                start = lastConvertedZro + 1;
                lastConvertedZro = end;
            }
            max = Math.max(max, end - start + 1 - zero);
        }
        return max - (zero == 1 ? 0 : 1);
    }
}