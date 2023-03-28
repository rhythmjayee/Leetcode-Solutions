class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] dayIncluded = new boolean[366];
        for (int day : days) {
            dayIncluded[day] = true;
        }
        int[] minCost = new int[366];
        minCost[0] = 0;
        for (int day = 1; day <= 365; ++day) {
            if (!dayIncluded[day]) {
                minCost[day] = minCost[day-1];
                continue;
            }
            int min;
            //min cost will be prev day cost plus 1 day ticks cost
            min = minCost[day-1] + costs[0];
            //min cost will be prev 7 day cost plus 7 day ticks cost
            min = Math.min(min, minCost[Math.max(0, day-7)] + costs[1]);
            //min cost will be prev 30 day cost plus 30 day ticks cost
            min = Math.min(min, minCost[Math.max(0, day-30)] + costs[2]);
            minCost[day] = min;
        }

        return minCost[365];
    }
}