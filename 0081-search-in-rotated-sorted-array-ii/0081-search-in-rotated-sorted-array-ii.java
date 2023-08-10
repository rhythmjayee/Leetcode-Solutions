class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        
        while(i <= j){
            int mid = i + ((j - i)>>1);
            if(nums[mid] == target) return true;
            //sorted [i .... mid]
            if(nums[i] < nums[mid]){
                if(nums[i] <= target && nums[mid] > target){
                    j = mid - 1; //[i ..t.. mid]
                }else{
                    i = mid + 1;//[mid .. t .. j]
                }//sorted [mid .... j]
            }else if(nums[mid] < nums[i]){
                if(nums[j] >= target && target > nums[mid]){
                     i = mid + 1;
                }else{
                     j = mid - 1;
                }
            }else{
                i++;
            }
        }
        return false;
    }
}