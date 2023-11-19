class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        
        Arrays.sort(nums);
        int smallest = nums[0];
        
        while(i < n && nums[i] == smallest) i++;
        if(i == n) return 0;
        
        int count = 0;
        while(j >= i) {
            int largest = nums[j];
            int cnt = 0;
            while(j >= i && nums[j] == largest) {
                j--;
            }
            cnt = n - j - 1;
            count = (count + cnt);
            // System.out.println(largest+" "+cnt+" "+count);
        }
        return count;
    }
}