class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        if(m > n) return "";
        
        int start = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int ansStart = -1;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < m; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int end = 0; end < n; end++) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count++;
            }
                            
            while(start <= end && count == map.size()) {
                if(end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    ansStart = start;
                }
                char ch = s.charAt(start);
                if(map.containsKey(ch)) {
                    int f = map.get(ch);
                    map.put(ch, f + 1);
                    if(f == 0) count--;
                }
                start++;
            }
        }
        return 
            minLen != Integer.MAX_VALUE ? s.substring(ansStart, ansStart + minLen) : "";
    }
}
/**
s = "ADOBEC-ODEBANC", t = "ABC"
ADOBEC
DOBECODEBA
OBECODEBA
BECODEBA
ECODEBA
CODEBA
ODEBANC
DEBANC
EBANC
BANC
*/