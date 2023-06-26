class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a , b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a , b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int n = costs.length;
        int i = 0;
        int j = n - 1;
        
        if(k >= n) {
            for(int x : costs) {
                cost += x;
            }
            return cost;
        }
        
        while(k > 0) {
            while((i < j )&& pq1.size() < candidates) {
                pq1.add(new int[]{i, costs[i]});
                i++;
            }
            while(i <= j && pq2.size() < candidates) {
                pq2.add(new int[]{j, costs[j]});
                j--;
            }
            
            int[] v1 = pq1.size() > 0 ? 
                pq1.peek() : new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
            int[] v2 = pq2.size() > 0 ? 
                pq2.peek() : new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
            
            if(v1[1] <= v2[1]) {
                cost += v1[1];
                pq1.remove();
            }else {
                cost += v2[1];
                pq2.remove();
            }
            k--;
        }
        return cost;
    }
}