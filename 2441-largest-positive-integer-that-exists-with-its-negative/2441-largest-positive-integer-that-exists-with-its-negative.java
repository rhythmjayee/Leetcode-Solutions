class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        
        for(int x : nums){
            set.add(x);
            if(set.contains(-x)) max = Math.max(max, Math.abs(x));
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}