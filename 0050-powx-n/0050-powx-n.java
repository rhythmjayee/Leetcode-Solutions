class Solution {
    public double myPow(double x, int n) {
        double res = pow(x, n);
        if(n < 0) {
            res = 1.0 / res;
        }
        return res;
    }
    private double pow(double x, int n) {
        if(n == 0) return 1.0;
        else if(n == 1) return x;
        double res = pow(x, n/2);
        res *= res;
        if((n & 1) != 0) {
            res *= x;
        }
        return res;
    }
}
