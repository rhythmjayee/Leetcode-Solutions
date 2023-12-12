class Solution {
    public int maxProduct(int[] nums) {
        int l1 = Integer.MIN_VALUE;
        int l2 = Integer.MIN_VALUE; 
        int s1 = Integer.MAX_VALUE;
        int s2 = Integer.MAX_VALUE; 
        
        for(int x : nums) {
            if(l1 < x) {
                l2 = l1;
                l1 = x;
            } else if(l2 < x) {
                l2 = x;
            }
            //below condition will need if array contains negative nos also
            if(s1 > x) {
                s2 = s1;
                s1 = x;
            } else if(s2 > x) {
                s2 = x;
            }
        }
        
        int max = Math.max((l2 - 1) * (l1 - 1), (s2 - 1) * (s1 - 1));
        return max;
    }
}