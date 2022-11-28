class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> win = new HashMap<>();
        Map<Integer, Integer> lose = new HashMap<>();
        
        for(int[] m : matches) {
            win.put(m[0], win.getOrDefault(m[0] , 0) + 1);
            lose.put(m[1], lose.getOrDefault(m[1] , 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ww = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        for(int w : win.keySet()) {
            if(!lose.containsKey(w)) {
                ww.add(w);
            }
        }
        for(int l : lose.keySet()) {
            if(lose.containsKey(l) && lose.get(l) == 1) {
                ll.add(l);
            }
        }
        Collections.sort(ww);
        Collections.sort(ll);
        ans.add(ww);
        ans.add(ll);
        
        return ans; 
    }
}