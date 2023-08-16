class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        for(int i = 0; i < n; i++) {
            //remove out of window numbers
            while(!dq.isEmpty() && i - dq.getFirst() >= k) 
                dq.removeFirst();
            //remove number <= curr from end of window
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) 
                dq.removeLast();
            
            dq.addLast(i);
            //Number at front of window will be largest
            if(i >= k - 1) {
                ans[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return ans;
    }
}