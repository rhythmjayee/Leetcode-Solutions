class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int dup = 0;
        Set<Integer> set = new HashSet<>();
        for(int x : arr) {
            max = Math.max(max, x);
            min = Math.min(min, x);
            if(set.contains(x)) dup = 1;
            set.add(x);
        }
        int gap = max - min;
        int d = gap / (arr.length - 1);
        if(Math.ceil((double)gap / (arr.length - 1)) != Math.floor((double)gap / (arr.length - 1))) return false;
        else if(dup == 1 & d != 0) return false;
        for(int x : arr) {
            if(!(set.contains(x - d) || set.contains(x + d))) return false;
        }
        return true;
    }
}