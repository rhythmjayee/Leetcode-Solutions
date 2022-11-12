class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int max = 0;
        int j = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while(map.containsKey(c) && j <= map.get(c)) {
                j = map.get(c) + 1;
            }
            map.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}