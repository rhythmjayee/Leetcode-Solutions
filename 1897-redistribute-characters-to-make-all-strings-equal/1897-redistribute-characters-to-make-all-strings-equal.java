class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] f = new int[26];
        for(String s : words) {
            for(char c : s.toCharArray()) {
                f[c - 'a']++;
            }
        }
        for(int x : f) {
            if(x % n != 0) return false;
        }
        return true;
    }
}