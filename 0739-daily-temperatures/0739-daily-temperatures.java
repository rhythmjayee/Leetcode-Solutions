class Solution {
    public int[] dailyTemperatures(int[] t) {
        Deque<Integer> sk = new LinkedList<>();
        int n = t.length;
        int[] ans = new int[n];
        
        for(int i = n - 1; i >= 0; i--) {
            while(!sk.isEmpty() && t[sk.getLast()] <= t[i]) {
                    sk.removeLast();
            }
            if(sk.isEmpty()) {
                ans[i] = 0;
            }else if(t[sk.getLast()] > t[i]) {
                ans[i] = sk.getLast() - i;
            }
            sk.addLast(i);
        }
        return ans;
    }
}