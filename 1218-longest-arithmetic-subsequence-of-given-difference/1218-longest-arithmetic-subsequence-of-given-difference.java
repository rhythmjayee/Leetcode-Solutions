class Solution {
    public int longestSubsequence(int[] arr, int diff) {
       Map<Integer, Integer> map = new HashMap<>();
        int longSeq = 0;
        for(int x : arr) {
            if(map.containsKey(x - diff)) {
                int max = Math.max(map.getOrDefault(x, 0), map.get(x - diff) + 1);
                map.put(x, max);
                // System.out.println(x + " "+ max);
            }
            map.putIfAbsent(x, 1);
            longSeq = Math.max(longSeq, map.get(x));
        }
        return longSeq;
    }
}