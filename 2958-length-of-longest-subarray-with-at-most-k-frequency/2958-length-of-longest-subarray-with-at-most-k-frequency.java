class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int n = nums.length;
        int max = 0;
        for(int end = 0; end < n; end++) {
            int x = nums[end];
            map.put(x, map.getOrDefault(x, 0) + 1);
            while(start <= end && map.get(x) > k) {
                int sx = nums[start++];
                int y = map.get(sx);
                if(y == 1) map.remove(sx);
                else map.put(sx, y - 1);
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}