class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i = 0;
        int j = piles.length - 1;
        int sum = 0;
        while(j - i > 1) {
            sum += piles[j - 1];
            j -= 2;
            i += 1;
        }
        return sum;
    }
}
/*
[9,8,7,6,5,1,2,3,4]
1 8 9 -> 8
2 6 7 -> 6
3 4 5 -> 4

*/