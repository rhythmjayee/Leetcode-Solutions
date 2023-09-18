class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });
        
        for(int i = 0; i < mat.length; i++) {
            int count = 0;
            for(int j = 0; j < mat[0].length && mat[i][j] == 1; j++) {
                count++;
            }
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
        int idx = 0;
        while(!pq.isEmpty()) {
            ans[k - idx - 1] = pq.poll()[1];
            idx++;
        }
        return ans;
    }
}