class Solution {
    public int lengthOfLongestSubstring(String s) {
        //contains character first occurance index in window
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int max = 0;
        //start of window
        int j = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //check if charcter is already present in window
            //if present then change the window start to just next index
            if(map.containsKey(c) && j <= map.get(c)) {
                j = map.get(c) + 1;
            }
            map.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}