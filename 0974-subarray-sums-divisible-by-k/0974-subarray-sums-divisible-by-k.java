class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        
        for(int x : nums) {
            sum += x;
            //handle negative sum
            int remainder = (sum % k + k) % k;
            if(remainder == 0) count++;
            
            if(map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
    /*
     4 4 4 2  4  0
    [4,5,0,-2,-3,1]
     4 9 9 7 4   5
    */
}