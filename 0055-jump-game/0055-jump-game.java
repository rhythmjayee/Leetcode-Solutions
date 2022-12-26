class Solution {
    public boolean canJump(int[] nums) {
        int steps = nums[0];
        int maxfarCanGo = nums[0];
        int n = nums.length;
        
        for(int i = 1; i<n; i++) {
            if(steps == 0) return false;
            else if(i == n - 1) return true;
            //get how far we can go using the ith jumps
            maxfarCanGo = Math.max(maxfarCanGo, i + nums[i]);
            //reach ith position, decrease one step
            steps--;
            
            if(steps == 0) {
                //get more steps can be taken to reach maxfarCanGo from i
                steps += maxfarCanGo - i;
                if(steps <= 0) return false;
            }
        }
        
        return true;
    }
}