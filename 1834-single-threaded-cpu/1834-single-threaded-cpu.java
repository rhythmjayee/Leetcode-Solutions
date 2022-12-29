class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int idx = 0;
        //index, enque_t, processing_t
        int[][] t = new int[n][3];
        for(int i = 0; i<n; i++) {
            t[i] = new int[]{i, tasks[i][0], tasks[i][1]};
        }
        //Sort on enque_t, index
        Arrays.sort(t, (a, b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        //index, processing_t
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int i = 0;
        //add min time tasks
        int time = t[i][1];
        while(i < n && time == t[i][1]) {
            pq.add(new int[]{t[i][0], t[i][2]});
            i++;
        }
       
        while(!pq.isEmpty()) {
            int[] rm = pq.remove();
            ans[idx++] = rm[0];//added index of processed task
            time += rm[1];//add processing time of curr tasks to time
            //get all the tasks whose enq_t <= curr time
            while(i < n && (t[i][1] <= time || pq.isEmpty())) {
                if(t[i][1] > time &&pq.isEmpty()) {
                    //no tasks is there for curr time so CPU will be idle
                    //directly jump time to next smaller enq_t
                    time = t[i][1];
                }
                pq.add(new int[]{t[i][0], t[i][2]});
                i++;
            }
        }
        return ans;
    }
}