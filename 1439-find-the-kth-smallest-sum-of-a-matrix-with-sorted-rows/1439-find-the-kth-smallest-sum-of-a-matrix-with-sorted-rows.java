class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int col = Math.min(mat[0].length, k);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            // max priority queue for the i-th row
            PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : pq) {
                for (int c = 0; c < col; c++) {
                    //add combination of sum with next rows, add it to PQ
                    nextPq.add(i + row[c]);
                    // keep pq size <= k
                    //remove the larger sums > kth sum
                    if (nextPq.size() > k) {
                        nextPq.poll();
                    }
                }
            }
            pq = nextPq;
        }
        return pq.poll();
    }
}