class Solution {
    public int getWinner(int[] arr, int k) {
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }
        
        int curr = arr[0];
        int winstreak = 0;
        
        for (int i = 1; i < arr.length; i++) {
            int opponent = arr[i];
            //if curr element is greater, winstreak++
            if (curr > opponent) {
                winstreak++;
            } else {//else curr will be changed
                curr = opponent;
                winstreak = 1;
            }
            //element which wins k consecutive rounds or
            //we get curr as maxElement, which will win every round
            if (winstreak == k || curr == maxElement) {
                return curr;
            }
        }
        
        return -1;
    }
}