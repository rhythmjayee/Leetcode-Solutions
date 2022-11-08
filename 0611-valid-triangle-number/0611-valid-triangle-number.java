class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = j + 1;
            while(j < n && k < n) {
                int sumOfSmallerSides = nums[i] + nums[j];
                if(j != k && sumOfSmallerSides > nums[k]) {
                    count += k - j;
                    k++;
                }else {
                    j++;
                    if(j >= k) k++;
                }
            }
        }
        return count;
    }
}
