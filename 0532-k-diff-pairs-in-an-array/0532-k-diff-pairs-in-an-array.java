class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = 1;
        int count = 0;
        while(i < n && j < n) {
            int diff = nums[j] - nums[i];
            if(i != j && diff == k) {
                count++;
                while(i < n - 1 && nums[i] == nums[i + 1]) i++;
                while(j < n - 1 && nums[j] == nums[j + 1]) j++;
                i++; j++;
            }else if(diff < k) {
                //gap is still < k -> inc jth
                j++;
            }else {
                //gap is becomes > k -> inc ith
                i++;
            }
        }
        return count;
    }
}
//1 1 3 4 5