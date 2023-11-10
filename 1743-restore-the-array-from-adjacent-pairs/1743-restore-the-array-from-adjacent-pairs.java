class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] ans = new int[n];
        Integer front = null;
        Integer last = null;
        for(int[] x : adjacentPairs) {
            map.putIfAbsent(x[0], new HashSet<>());
            map.putIfAbsent(x[1], new HashSet<>());
            map.get(x[0]).add(x[1]);
            map.get(x[1]).add(x[0]);
        }
        for(int key : map.keySet()) {
            if(front == null && map.get(key).size() == 1) front = key;
            else if(last == null && map.get(key).size() == 1) last = key;
        }
        ans[0] = front;
        ans[n - 1] = last;
        // System.out.println(front +" "+last);
        for(int i = 1; i < n - 1; i++) {
            int x = map.get(ans[i - 1]).iterator().next();
            ans[i] = x;
            // System.out.println(ans[i-1] +" "+x );
            // System.out.println(map.get(x) );
            map.get(x).remove(ans[i - 1]);
        }
        return ans;
    }
}