class Solution {
    public boolean checkStraightLine(int[][] xy) {
        int x0 = xy[0][0];
        int y0 = xy[0][1];
        int x1 = xy[1][0];
        int y1 = xy[1][1];
        for(int i = 2; i<xy.length; i++) {
            int x = xy[i][0];
            int y = xy[i][1];
            if((x1 - x0) * (y - y1) != (x - x1) * (y1 - y0)) return false;
        }
        return true;
    }
}