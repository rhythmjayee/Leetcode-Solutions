class Solution {
    public int maxProductDifference(int[] nums) {
        int a = 0;
        int b = 0;
        int c = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;
        
        for(int x : nums) {
            if(x >= a) {
                b = a;
                a = x;
            } else if(x > b) {
                b = x;
            } 
            
            if(x <= c) {
                d = c;
                c = x;
            } else if(x < d) d = x;
        }
        
        return (a * b) - (c * d);
    }
}