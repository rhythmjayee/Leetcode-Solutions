class Solution {
    public int firstUniqChar(String s) {
        int[] f = new int[26];
        Arrays.fill(f, -1);
        int indx = -1;
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(f[c - 'a'] == -1) {
                f[c - 'a'] = i;
            } else {
                f[c - 'a'] = -2;
            }
        }
        int min = s.length();
        for(int i = 0; i<26; i++) {
            if(f[i] >= 0) {
                min = Math.min(min, f[i]);
            }
        }
        return min == s.length() ? -1 : min;
    }
}