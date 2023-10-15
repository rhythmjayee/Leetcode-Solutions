class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        // Labels and their corresponding number of items.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> values[b] - values[a]);
        Map<Integer, Integer> limits = new HashMap<>();
        for (int i = 0; i < labels.length; i++) {
            if (!limits.containsKey(labels[i])) {
                limits.put(labels[i], 0);
            }
            pq.add(i);
        }
        
        int max = 0;
        // The number of items in the set may less than num_wanted.
        for (int i = 0; i < num_wanted && !pq.isEmpty(); ) {
            int idx = pq.remove();
            if (limits.get(labels[idx]) < use_limit) {
                max += values[idx];
                limits.put(labels[idx], limits.get(labels[idx]) + 1);
                i++;
            }
        }
        return max;
    }
}