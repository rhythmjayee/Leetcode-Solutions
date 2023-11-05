class Solution {
    public int getWinner(int[] arr, int k) {
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
            //element which wins k consecutive rounds
            if (winstreak == k) {
                return curr;
            }
        }
        //after loop finish, curr will store max element
        return curr;
    }
}