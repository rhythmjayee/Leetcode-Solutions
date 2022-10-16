class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> m = new HashSet<>();
        for(int x : nums){
            m.add(x);
            int y = rev(x);
            m.add(y);
        }
        return m.size();
    }
    public int rev(int x){
        int newNum = 0;
        while(x > 0){
            int l = x % 10;
            newNum = newNum * 10 + l;
            x /= 10;
        }
        return newNum;
    }
}