class Solution {
    public int jump(int[] nums) {
        int minJumps = 0;
        int stepsReamining = nums[0];
        int maxFarCanGo = nums[0];
        
        if(nums.length == 1) return 0;
        else if(nums[0] == 0) return -1;
        
        for(int i = 1; i<nums.length; i++) {
            if(i == nums.length - 1) {
                return minJumps + 1; //+1 for inital jump from 0th pos
            }
            maxFarCanGo = Math.max(maxFarCanGo, i + nums[i]);
            stepsReamining--;
            if(stepsReamining == 0) {
                stepsReamining += maxFarCanGo - i;
                if(stepsReamining <= 0) return -1;
                minJumps++;
            }
        }
        return -1;
    }
}