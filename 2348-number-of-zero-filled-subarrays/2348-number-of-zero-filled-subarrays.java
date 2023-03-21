class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int n = nums.length;
        int start = -1;
        //Number of sub arrays not formed till ith index = end - start + 1
        for (int end = 0; end < n; end++) {
            if (nums[end] == 0 && start == -1) {//start of subarray
                count += 1;//subarray with single element
                start = end;
            }else if (nums[end] == 0) {//add no.of subarrays not counted & ending at end index
                count += (end - start + 1);
            }else start = -1;
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