class Solution {
    int start = 0;
    int maxLen = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i<n; i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }
    private void expand(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if(j - i + 1 > maxLen) {
                start = i;
                maxLen = j - i + 1;
            }
            i--;
            j++;
        }
    }
}