class Solution {
    public int largestAltitude(int[] gain) {
        int h = 0;
        int max = 0;
        for(int x : gain) {
            h += x;
            max = Math.max(max, h);
        }
        return max;
    }
}