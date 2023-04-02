class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        
        Arrays.sort(potions);
        for(int i = 0; i < n; i++) {
            long minPotion = (long) Math.ceil((1.0 * success) / spells[i]);
            // Check if we don't have any potion which can be used.
            if (minPotion > potions[m - 1]) {
                ans[i] = 0;
                continue;
            }
            int idx = getNumberOfValidPotions(potions, (int)minPotion);
            ans[i] = m - idx;
        }
        return ans;
    }
    public int getNumberOfValidPotions(int[] arr, int atleast) {
        int idx = -1;
        int i = 0;
        int j = arr.length - 1;
        
        while(i <= j) {
            int m = i + ((j - i) >> 1);
            if(arr[m] >= atleast) {
                idx = m;
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        
        return idx;
    }
}