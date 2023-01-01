class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] st = s.split("\\s+");
        if(pattern.length() != st.length) return false;
        
        for(int i = 0; i<st.length; i++) {
            char c = pattern.charAt(i);
            String ss = st[i].trim();
            if((map1.containsKey(c) && !map1.get(c).equals(ss)) || 
              (map2.containsKey(ss) && map2.get(ss) != c)) return false;
            map1.put(c, ss);
            map2.put(ss, c);
        }
        return true;
    }
}