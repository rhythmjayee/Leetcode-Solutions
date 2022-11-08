class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        for(int k = n - 1; k >= 2; k--) {
            //fix largest side -> k
            int i = 0;
            int j = k - 1;
            //fix 2nd side -> j
            while(i < j) {
                int sumOfSmallerSides = nums[i] + nums[j];
                //In triangle ->
                //Sum of 2 smaller side > largest side
                if(sumOfSmallerSides > nums[k]) {
                    //on fixing 3rd, 2nd sides -> sumOfSmallerSides > 3rd side
                    //so for side combination with 3rd, 2nd & smallest sides is also correct
                    //j - i -> all side bw [i, j]
                    count += j - i;
                    //make 2nd side lesser
                    j--;
                }else {
                    //1st side is more smaller, cant be used
                    i++;
                }
            }
        }
        return count;
    }
}

// 2 3 4 4
// 2 3 4
// 2 3 4