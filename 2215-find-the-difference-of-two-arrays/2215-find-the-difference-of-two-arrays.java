class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> ls1 = new HashSet<>();
        Set<Integer> ls2 = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();
        
        for(int x : nums1) {
            ls1.add(x);
        }
        for(int x : nums2) {
            ls2.add(x);
        }
        for(int x: ls2) {
            if(ls1.contains(x)) {
                ls1.remove(x);
                tmp.add(x);
            }
        }
        for(int x : tmp) {
            ls2.remove(x);
        }
        
        List<Integer> l1 = ls1.stream().collect(Collectors.toList());
        List<Integer> l2 = ls2.stream().collect(Collectors.toList());
        ans.add(l1);
        ans.add(l2);
        return ans;
    }
}