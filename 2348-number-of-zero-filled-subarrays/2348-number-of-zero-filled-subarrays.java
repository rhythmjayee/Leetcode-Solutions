class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int n = nums.length;
        int prev = -1;
        for(int i = 0; i<n; i++) {
            if(nums[i] == 0 && prev == -1) {
                count += 1;
                prev = i;
            }else if(nums[i] == 0) {
                count += (i - prev + 1);
            }else prev = -1;
        }
        return count;
    }
}

/*
[0,0,0,0,0]
1
2
3
4
5


[0,0,0,2,0,0]
1
2
3
1
2
*/