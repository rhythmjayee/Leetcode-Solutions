class Solution {
    public int rev(int x) {
        int num = 0;
        while(x > 0) {
            num = (num * 10) + (x % 10);
            x = x / 10;
        }
        return num;
    }
    public int countNicePairs(int[] nums) {
        int mod = (int)(1e9 + 7);
        //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        //nums[i] - rev(nums[i]) = nums[j] - rev(nums[j])
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for(int x : nums) {
            int revX = rev(x);
            int diff = x - revX;
            if(map.containsKey(diff)) {
                ans += map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return (int)(ans % mod);
    }
}