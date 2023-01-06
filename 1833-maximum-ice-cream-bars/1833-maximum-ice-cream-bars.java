class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for(int x : costs) {
            if(coins >= x) {
                coins -= x;
                count++;
            }
            else break;
        }
        return count;
    }
}