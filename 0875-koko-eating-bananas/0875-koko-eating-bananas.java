class Solution {
    private int max(int[] nums) {
        int mx = 0;
        for(int x : nums) mx = Math.max(mx, x);
        return mx;
    }
    private boolean canEatAllInTime(int[] p, int k, int h) {
        int time = 0;
        for(int x : p) {
            if(x <= k) {
                time++;
            }else {
                int d = x/k;
                time += (x % k == 0 ? d : d + 1);
            }
            
            if (time > h) break;
        }
        return time <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = max(piles);
        while(i < j) {
            int k = i + ((j - i) >> 1);
            // System.out.println(k);
            if(canEatAllInTime(piles, k, h)) {
                j = k;
            }else {
                i = k + 1;
            }
        }
        return j;
    }
}