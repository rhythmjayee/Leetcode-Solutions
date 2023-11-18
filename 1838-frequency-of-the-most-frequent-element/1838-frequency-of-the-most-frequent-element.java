class Solution {
    public int maxFrequency(int[] nums, int k) {
        //sort so that we can have some set of elements
        //which are closer and can result in ans
        Arrays.sort(nums);
        int left = 0;
        int ans = 0;
        //maintain the sum of elements in window
        long curr = 0;
        
        for (int right = 0; right < nums.length; right++) {
            int target = nums[right];
            curr += target;
            //for each target check whether we can make elements in window to target
            //(right - left + 1) * target -> total sum if all elements in window is target
            //curr -> window sum
            while ((right - left + 1) * target - curr > k) {
                curr -= nums[left];
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans;
    }
}