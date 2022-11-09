class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //atmost(k) - atmost(k-1) = Total(k)
        return atMostKOddNumsSubarrays(nums, k) - atMostKOddNumsSubarrays(nums, k - 1);
    }
    //count subarrays with atmost k odd nos.
    public int atMostKOddNumsSubarrays(int[] nums, int k) {
        int n = nums.length;
        int odd = 0;
        int count = 0;
        int j = 0;
        for(int i = 0; i<n; i++) {
            if(nums[i] % 2 != 0) odd++;
            while(j <= i && odd > k) {
                if(nums[j++] % 2 != 0) odd--;
            }
            count += (i - j + 1);
        }
        return count;
    }
}
/*
1,1,2,1,1
atmost k=3
1
11 1
112 12 2
1121 121 21 1
1211 211 11 1
atmost k=2
1
11 1
112 12 2
121 21 1
211 11 1
*/