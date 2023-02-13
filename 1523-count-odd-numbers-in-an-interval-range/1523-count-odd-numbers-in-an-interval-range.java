class Solution {
    public int countOdds(int low, int high) {
        int odd = 0;
        if( (low&1) !=0 ) {
            odd++;
        }
        if( (high&1) !=0 ) {
            odd++;
        }
        return (odd + ((high - low - odd) >> 1));
    }
}