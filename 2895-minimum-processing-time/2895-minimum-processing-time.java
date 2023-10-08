class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, (a, b) -> b - a);
        int n = processorTime.size();
        int j = 0;
        int max = 0;
        for(int i = 0; i<n; i++) {
            int x = processorTime.get(i);
            int mx = 0;
            int e = j + 4;
            for(; j < e; j++) {
                mx = Math.max(mx, x + tasks.get(j));
            }
            max = Math.max(max, mx);
        }
        return max;
    }
}