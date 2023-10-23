class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        double[][] time = new double[n][2];
        for(int i = 0; i<n; i++) {
            time[i][0] = (double)(target - position[i]) / speed[i];
            time[i][1] = (double)position[i];
        }
        //sort based on position, faster car behind slower car form a fleet
        Arrays.sort(time, (a, b) -> Double.compare(a[1], b[1]));
        Deque<Double> sk = new LinkedList<>();
        //[6, 3, 7, 1, 1]
        for(double[] x : time) {
            while(!sk.isEmpty() && sk.getLast() <= x[0]) {
                sk.removeLast();
            }
            sk.addLast(x[0]);
        }
        return sk.size();
    }
}