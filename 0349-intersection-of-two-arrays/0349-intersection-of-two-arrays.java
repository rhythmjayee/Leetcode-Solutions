class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersection(nums2, nums1);
        
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int x : nums1) {
            set.add(x);
        }
        for(int x : nums2) {
            if(set.contains(x)) {
                ans.add(x);
                set.remove(x);
            }
        }
        
        int[] ls = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            ls[i] = ans.get(i);
        }
        return ls;
    }
}