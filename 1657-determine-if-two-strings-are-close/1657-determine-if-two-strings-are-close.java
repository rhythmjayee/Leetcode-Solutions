class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        //add chrs freq
        Map<Integer, Integer> f1 = new HashMap<>();
        for(char c : word1.toCharArray()) {
            int x = c - 'a';
            f1.put(x, f1.getOrDefault(x, 0) + 1);
        }
        Map<Integer, Integer> f2 = new HashMap<>();
        for(char c : word2.toCharArray()) {
            int x = c - 'a';
            if(!f1.containsKey(x)) return false;
            f2.put(x, f2.getOrDefault(x, 0) + 1);
        }
        //count diff freqs
        Map<Integer, Integer> f11 = new HashMap<>();
        for(int x : f1.values()) {
            f11.put(x, f11.getOrDefault(x, 0) + 1);
        }
        for(int x : f2.values()) {
             if(!f11.containsKey(x)) return false;
            f11.put(x, f11.get(x) - 1);
        }
        for(int x : f11.values()) {
            if(x != 0) return false;
        }
        return true;
    }
    /*
     "cabbbacabbba"
     "abbccccabbba"
     a - 4
     b - 6
     c - 2
     
     a - 3
     b - 5
     c - 4
    */
}