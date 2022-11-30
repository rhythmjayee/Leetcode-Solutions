class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = arr.length;
        int[] f = new int[n+1];
        for(int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        for(int value : freq.values()) {
            f[value]++;
            if(f[value] > 1) return false;
        }
        return true;
    }
}