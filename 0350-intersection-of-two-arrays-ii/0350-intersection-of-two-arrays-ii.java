class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i : nums1) {
            m.put(i,m.getOrDefault(i,0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i : nums2) {
            if(m.containsKey(i) && m.get(i) > 0) {
                ans.add(i);
                m.put(i,m.getOrDefault(i,0)-1);
            }
        }
        return  ans.stream().mapToInt(i -> i).toArray();
        
    }
}