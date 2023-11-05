class Solution {
    public int getWinner(int[] arr, int k) {
        int maxOfAll = 0;
        int winstreak = 0;
        
        Deque<Integer> dq = new LinkedList<>();
        for(int x : arr) {
            dq.addLast(x);
            maxOfAll = Math.max(maxOfAll, x);
        }
        int curr = dq.removeFirst();
        while(!dq.isEmpty()) {
            int opponent = dq.removeFirst();
            if (curr > opponent) {
                dq.addLast(opponent);
                winstreak++;
            } else {
                dq.addLast(curr);
                curr = opponent;
                winstreak = 1;
            }
            
            if (winstreak == k || curr == maxOfAll) {
                return curr;
            }
        }
        return -1;
    }
}