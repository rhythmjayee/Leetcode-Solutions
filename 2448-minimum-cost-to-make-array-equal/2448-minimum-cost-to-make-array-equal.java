class Solution {
    public long minCost(int[] nums, int[] cost) {

        int[][] data = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++)
            data[i] = new int[]{nums[i],cost[i]};

        Arrays.sort(data, Comparator.comparingInt(a -> a[0]));

        int idx = 0, maxCost = Integer.MIN_VALUE;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < data.length; i++) {
            preSum[i + 1] = preSum[i] + data[i][1];
            if (data[i][1] > maxCost){
                idx = i;
                maxCost = data[i][1];
            }
        }

        long sum = preSum[preSum.length - 1];
        int lastIdx = -1;
        //find index to which other numbers should be converted 
        //inorder to get min sum
        //taking index of number having max cost as reference
        while (lastIdx != idx) {
            lastIdx = idx;
            //if forword has less cost
            if (preSum[idx + 1] < sum - preSum[idx + 1]) idx++;
            //if curr pos has more cost
            else if (preSum[idx] > sum - preSum[idx]) idx--;
        }

        long res = 0l;
        //Now other nos will be converted to no. at idx
        //cost will be added for abs diff to idx no.
        for (int i = 0; i < nums.length; i++)
            res += 1l * Math.abs(nums[i] - data[idx][0]) * cost[i];
        return res;
    }
}