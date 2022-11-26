class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
         int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        //Sort jobs which are getting finished first
        Arrays.sort(jobs, (a, b)->a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);//for getting floor for first time
        //For each Job find floor job with endtime of other job & its profit till now
        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            //last entry will be less than job[1]
            //as we traversing over sorted jobs on endtime
            if (cur > dp.lastEntry().getValue())
                dp.put(job[1], cur);
        }
        return dp.lastEntry().getValue();
    }
}