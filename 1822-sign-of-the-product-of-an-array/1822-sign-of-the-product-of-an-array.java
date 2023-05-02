class Solution {
    public int arraySign(int[] nums) {
        int sign = 0;
        for(int x : nums) {
            if(x == 0) return 0;
            else if(x < 0) sign++;
        }
        return sign % 2 == 0 ? 1 : -1;
    }
}