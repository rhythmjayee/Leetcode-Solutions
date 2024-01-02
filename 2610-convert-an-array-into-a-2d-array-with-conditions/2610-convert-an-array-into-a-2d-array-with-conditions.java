class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int max = 0;
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, map.get(nums[i]));
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        int op = 0;
        while(max > 0) {
            List<Integer> ls = new ArrayList<>();
            Set<Integer> set = map.keySet();
            for(int k : set) {
                int val = map.get(k);
                if(val - op <= 0) {
                    continue;
                }
                ls.add(k);
            }
            max--;
            op++;
            ans.add(ls);
        }
        return ans;
    }
}