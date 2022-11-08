class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n - 2; i++) {
            //fix 1st side
            int j = i + 1;
            int k = j + 1;
            while(j < n && k < n) {
                int sumOfSmallerSides = nums[i] + nums[j];
                //1st, 2nd sides sum > 3rd side
                if(sumOfSmallerSides > nums[k]) {
                    //count sides combination bw [j, k] with new k
                    count += k - j;
                    k++;
                }else {
                    //2nd side is small, get more larger side
                    j++;
                    //j should be < k
                    if(j >= k) k++;
                }
            }
        }
        return count;
    }
}
