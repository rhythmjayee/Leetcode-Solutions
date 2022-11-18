class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k > n) return -1;
        int[] minMax = getMinMax(bloomDay);
        int i = minMax[0];
        int j = minMax[1];
        int ans = 0;
        
        while(i <= j) {
            int d = i + ((j - i) >> 1);
            int bouquets = getBouquets(bloomDay, d, k);
            if(bouquets < m) {
                i = d + 1;
            }else {
                ans = d;
                j = d - 1;
            }
        }
        return ans == 0 ? -1 : ans;
    }
    private int getBouquets(int[] bloomDay, int d, int k) {
        //to make bouquets of k adjcent flowers
        int count = 0;
        //total bouquets made till now
        int bouquets = 0;
        for(int i = 0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= d){
                count++;
                if(count == k) {
                    count = 0;
                    bouquets++;
                }
            }else if(count < k) {
                 count = 0;
            }
        }
        return bouquets;
    }
    private int[] getMinMax(int[] bloomDay) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x : bloomDay) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return new int[]{min, max};
    }
}