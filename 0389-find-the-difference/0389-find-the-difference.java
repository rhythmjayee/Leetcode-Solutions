class Solution {
    public char findTheDifference(String s, String t) {
        int[] f = new int[26];
        for(char c : t.toCharArray()) {
            f[c - 'a']++;
        }
        for(char c : s.toCharArray()) {
            f[c - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if (f[i] == 1) return (char)(i + 'a');
        }
        return '0';
    }
}