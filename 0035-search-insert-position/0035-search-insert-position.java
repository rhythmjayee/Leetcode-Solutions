class Solution {
    public int searchInsert(int[] nums, int t) {
        int n = nums.length;
        //set start, end points
        int i = 0;
        int j = n;
        
        while(i < j) {
            //get middle index
            int md = i + ((j - i) >> 1);
            if(nums[md] == t) return md;
            //if nums[md] > t -> set end point as md -> md can be the index
            else if(nums[md] > t) j = md;
            //if nums[md] < t -> set start point as md + 1 
            //-> md cant be the index as it occupied by smaller element nums[md]
            else i = md + 1;
        }
        return j;
    }
}