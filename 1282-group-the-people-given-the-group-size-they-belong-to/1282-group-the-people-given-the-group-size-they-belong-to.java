class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++) {
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }
        for(int size = 1; size <= n; size++) {
            if(!map.containsKey(size)) continue;
            List<Integer> ls = map.get(size);
            int i = 0;
            while(i < ls.size()) {
                List<Integer> gp = new ArrayList<>();
                while(gp.size() < size) {
                    gp.add(ls.get(i++));
                }
                ans.add(gp);
            }
        }
        return ans;
    }
}