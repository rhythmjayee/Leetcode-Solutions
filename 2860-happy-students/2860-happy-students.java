class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int count = 0;
        int ans = 0;
        int i = 0;
        int n = nums.size();
        if(nums.get(0) != 0) ans = 1; //not select any
        while(i < n) {
            count++;
            int x = nums.get(i);
            if(count > x) {
                if(i < n - 1 && nums.get(i+1) > count) ans++;
                else if(i == n - 1) ans++;
            }
            i++;
        }
        return ans;
    }
    /**
    0 2 3 3 6 6 7 7
    
    
    */
}