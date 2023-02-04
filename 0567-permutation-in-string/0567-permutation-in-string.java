class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;
        
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int matched = 0;
        int start = 0;
        for(int end = 0; end<m; end++){
            char ch = s2.charAt(end);
            
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0) matched++;
            }
            
            if(matched == map.size()) return true;
            
            if(end - start + 1 >= n){
                char c = s2.charAt(start++);
                if(map.containsKey(c)){
                    if(map.get(c) == 0) matched--;
                    map.put(c,map.get(c)+1);
                }
            }
        }
        return false;
    }
}