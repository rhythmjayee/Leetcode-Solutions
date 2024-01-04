class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        int c = 0;
        for(int k : map.keySet()) {
            int f = map.get(k); 
            if(f == 1) return -1;
            c += (f / 3) + (f % 3 > 0 ? 1 : 0);
        }
        return c;
    }
}