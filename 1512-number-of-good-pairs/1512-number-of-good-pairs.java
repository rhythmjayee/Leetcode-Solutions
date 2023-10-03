class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] f = new int[101];
        int sum = 0;
        for(int x : nums) f[x]++;
        for(int i = 1; i<=100; i++) {
            if(f[i] > 1) {
                sum += ((f[i] * (f[i] - 1)) >> 1);
            }
        }
        return sum;
    }
}