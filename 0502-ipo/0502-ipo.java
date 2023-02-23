class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] project = new int[n][2];
        for(int i = 0; i<n; i++) {
            project[i][0] = profits[i];
            project[i][1] = capital[i];
        }
        //sort on starting capital of project
        Arrays.sort(project, (p1, p2) -> p1[1] - p2[1]);
        //pq of max net profit of project 
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> {
            return p2 - p1;
        });
        
        int gain = w;
        int i = 0;
        while(i < n && k > 0) {
            //add project to pq whose capital <= gain
            while(i < n && gain >= project[i][1]) {
                pq.add(project[i++][0]);
            }
            if(pq.isEmpty()) break;
            //get gains from projects untill 
            //we can add more project with higher capital
            while(!pq.isEmpty() && k > 0) {
                gain += pq.remove();
                k--;
                if(i < n && gain >= project[i][1]) break;
            }
        }
        //if k > 0
        while(!pq.isEmpty() && k > 0) {
            gain += pq.remove();
            k--;
        }
        return gain;
    }
}