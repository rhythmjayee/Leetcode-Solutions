class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        
        for (int i = 0; i < tickets.length; i++) {
            /*
            For all the persons < k, they will come before kth person untill
            they have buyed the all tickets or tickets == kth's tickets count
            */
            if (i <= k) {
                time += Math.min(tickets[k], tickets[i]);
            } else {
               /*
               For all the persons > k, they will come after kth person has buyed the
               ticket so kth person would have already buyed one ticket before persons
               which are > k
               
               2 3 3, k = 0
               1 3 3 -> 3 3 1
               2 3 1 -> 3 1 2
               2 1 2 -> 1 2 2
               0 2 2 -> stop
               */
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        
        return time;
    }
}