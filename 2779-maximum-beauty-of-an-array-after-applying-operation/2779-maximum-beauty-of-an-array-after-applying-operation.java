class Solution {
    public int maximumBeauty(int[] nums, int k) {
        /*
        0 <= nums[i], k <= 10^5
        range can go to :
        [-10^5, (10^5 + 10^5)]
        [-10^5, 2*10^5]
        Make index start from 0:
        [0, 3*10^5]
        */
        /*
        prefix technique to increment the count for whole range
        for range [start, end]
        do [......, [start]++,.....,[end+1]--,....]
        so in the end prefix sum remains same
        */
        int offset = 100000;
        int[] freq = new int[300002];
        int n = nums.length;
        for(int i = 0; i<n; i++) {
            int start = nums[i] - k;
            int end = nums[i] + k;
            freq[start + offset]++;
            freq[end + offset + 1]--;
        }
        int max = 0;
        int sum = 0;
        for(int x : freq) {
            sum += x;
            max = Math.max(max, sum);
        }
        return max;
    }
}