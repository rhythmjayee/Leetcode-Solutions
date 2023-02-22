class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = 0;
        int mx = 0;
        for(int x : weights) {
            s += x;
            mx = Math.max(mx, x);
        }
        int i = mx;
        int j = s;
        while(i < j) {
            int potentialCap = i + ((j - i) >> 1);
            if(isPossibleToShip(potentialCap, days, weights)) {
                j = potentialCap;
            }else {
                i = potentialCap + 1;
            }
        }
        return j;
    }
    private boolean isPossibleToShip(int cap, int days, int[] w) {
        int daysReq = 1;
        int currW = w[0];
        for(int i = 1; i<w.length; i++) {
            int x = w[i];
            if(x > cap) return false;
            else if(currW + x <= cap) {
                currW += x;
            }else {
                daysReq += 1;
                currW = x;
            }
        }
        return daysReq <= days;
    }
}