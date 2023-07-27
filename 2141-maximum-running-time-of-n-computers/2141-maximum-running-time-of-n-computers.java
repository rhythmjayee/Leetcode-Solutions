public class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int power : batteries)
            sumPower += power;
        long left = 1, right = sumPower / n;
        long ans = -1;
        while (left <= right){
            long target = left + (right - left) / 2;
            long extra = 0;
            
            for (int power : batteries)
                extra += Math.min(power, target);

            if (extra >= (long)(n * target)) {
                ans = target;
                left = target + 1;
            }
            else
                right = target - 1;
        }
        return ans;
    }
}