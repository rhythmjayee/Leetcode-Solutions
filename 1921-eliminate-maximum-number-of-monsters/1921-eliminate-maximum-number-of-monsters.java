class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        Double[] time = new Double[n];
        for(int i = 0; i<n; i++) {
            time[i] = (double)dist[i] / speed[i];
        }
        Arrays.sort(time, (a, b) -> Double.compare(a, b));
        int count = 0;
        for(Double x : time) {
            double diff = x - (double)count;
            if(diff <= 0) break;
            count++;
        }
        return count;
    }
}