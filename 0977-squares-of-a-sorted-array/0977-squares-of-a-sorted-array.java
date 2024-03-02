class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        //max sq number can be get from smallest negative number
        int start = 0;
        int end = n - 1;
        int ansIndx = n - 1;
        while(start <= end) {
            int frontSq = nums[start] * nums[start];
            int EndSq = nums[end] * nums[end];
            if(frontSq >= EndSq) {
                ans[ansIndx--] = frontSq;
                start++;
            } else {
                ans[ansIndx--] = EndSq;
                end--;
            }
        }
        return ans;
    }
}