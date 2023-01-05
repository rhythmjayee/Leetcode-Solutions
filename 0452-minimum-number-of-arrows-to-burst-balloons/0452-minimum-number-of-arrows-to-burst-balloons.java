class Solution {
    public int findMinArrowShots(int[][] points) {
        //sort on the basis of end point,
        //as we want those balloons first which has lower end
        Arrays.sort(points, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int n = points.length;
        int count = 0;
        //selected end point
        int end = points[0][1];
        
        for(int i = 1; i<n; i++) {
            //if curr balloon doesnt lie under the end point
            //we have to use another arrow for curr balloon
            //so we change the end point to curr balloons end point
            if(end < points[i][0]) {
                end = points[i][1];
               count++;
            }
            //Try to collect all the balloons
            //who lies under the previous selected end point
        }
        count++;
        return count;
    }
}