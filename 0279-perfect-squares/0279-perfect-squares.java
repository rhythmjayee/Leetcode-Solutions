class Solution {
    public int numSquares(int n) {
        List<Integer> sqrs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int num = 1;
        for(int i = 1; i*i <= n; i++) {
            int sq = (i*i);
            if(sq == n) return num;
            sqrs.add(sq);
            q.add((n - sq));
        }
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                int nn = q.poll();
                for(int x : sqrs) {
                    if(x > nn) break;
                    else if(x == nn) return num + 1;
                    q.add((nn - x));
                }
            }
            if(q.size() != 0) num++; 
        }
        return num;
    }
}