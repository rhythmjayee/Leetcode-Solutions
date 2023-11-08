class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int x =  Math.abs(fx - sx);//x dig distance
        int y =  Math.abs(fy - sy);//y dig distance
        int min = Math.min(x, y);//min dig distance
        
        int minDis = min + (x - min + y - min);//cover min dig distance then rest straight distance
        return minDis == 0 && t == 1 ? false : minDis <= t;
    }
}