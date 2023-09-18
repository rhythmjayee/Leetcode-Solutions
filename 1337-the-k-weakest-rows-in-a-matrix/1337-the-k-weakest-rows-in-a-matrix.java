class Solution {
    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }
        
        return lo;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });
        
        for(int i = 0; i < mat.length; i++) {
            int count = numOnes(mat[i]);//BS to find the no. of 1s in row
            if(pq.size() < k) pq.add(new int[]{count, i});
            else {
                int[] rm = pq.peek();
                if(rm[0] > count) {
                    pq.remove();
                    pq.add(new int[]{count, i});
                }
            }
        }
        int[] ans = new int[k];
        while(!pq.isEmpty()) {
            ans[--k] = pq.poll()[1];
        }
        return ans;
    }
}