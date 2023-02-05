class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i<p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int start = 0;
        int matched = 0;
        List<Integer> ans = new ArrayList<>();
        
        for(int end = 0; end<s.length(); end++) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) matched++;
            }
            
            if(matched == map.size()) ans.add(start);
            
            if(end - start + 1 == p.length()) {
                char cc = s.charAt(start++);
                if(map.containsKey(cc)) {
                    if(map.get(cc) == 0) matched--;
                    map.put(cc, map.get(cc) + 1);
                }
            }
        }
        
        return ans;
    }
}