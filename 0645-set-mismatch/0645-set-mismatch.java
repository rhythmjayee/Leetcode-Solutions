class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i = 0; i<n; i++) {
            xor ^= (i+1);
            xor ^= nums[i];
        }
        
        int rmsb = xor&(-xor);
        int a = 0;
        int b = 0;
        
        for(int i = 0; i<n; i++) {
            if((rmsb & (i+1)) != 0) {
                a ^= (i+1);
            }else {
                b ^= (i+1);
            }
            
            if((rmsb & nums[i]) != 0) {
                a ^= nums[i];
            }else {
                b ^= nums[i];
            }
        }
        
        for(int x : nums) {
            if(x == a) {
                return new int[]{a,b};
            }else if(x == b) {
                return new int[]{b,a};
            }
        }
        
        return new int[0];
    }
}
/**
 [1,2,2,4]
 xor = 1 ^ 2 ^ 3 ^ 4
 XOR with nums
 xor = 1 ^ 2 ^ 3 ^ 4 ^ (1 ^ 2 ^ 2 ^ 4)
 xor = 2 ^ 3 -> xor is now combination of repeated number & missing no.
             -> so using right most set bit we divide the nums & (1->n) numbers
             -> into 2 different xor
*/