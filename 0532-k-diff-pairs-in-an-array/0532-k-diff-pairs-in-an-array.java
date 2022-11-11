class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int x : nums){
            //x is seen already, no need to process for k > 0 now
            if(map.containsKey(x)){
                //if k = 0, count if its x's 2nd occurance
                if(k == 0 && map.get(x) < 2) {
                    map.put(x, 2);
                    count++;
                }
                continue;
            }
            //x's first occurance
            if(map.containsKey(x - k)){
                count++;
            }
            if(map.containsKey(x + k)){
                count++;
            }
            
            map.put(x, 1);
        }
        return count;
    }
    /*
    |nums[i] - nums[j]| == k
     x- y = +- k
     x = y +- k
    */
}