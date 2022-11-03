class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        int count = 0;
        Set<String> v = new HashSet<>();
        int flag = 0;
        for(String w : map.keySet()) {
            String r = new StringBuilder(w).reverse().toString();
            if(!v.contains(r)) {
                int c = map.get(w);
                int rc = map.getOrDefault(r, 0);
                int min = Math.min(c, rc);
                if(min == 1 && w.charAt(0) == w.charAt(1)) flag = 1;
                else {
                    if(w.charAt(0) == w.charAt(1)) {
                        flag = min % 2 == 0 ? flag : 1;
                        min = min / 2;
                    }
                    // System.out.println(w+" -> "+min);
                    count += min*4;
                    v.add(w);
                }
            }
        }
        
        count = flag == 1 ? count + 2 : count;
        return count;
    }
}